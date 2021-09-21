package com.heroes.api;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    private final HeroesRepository repo;

    HeroController(HeroesRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/heroes")
    List<Hero> all() {
        return repo.findAll();
    }

    @PostMapping("/heroes")
    Hero newHero(@RequestBody Hero newHero) {
        return repo.save(newHero);
    }

    @PutMapping("/heroes/{id}")
    Hero updateHero(@RequestBody Hero newHero, @PathVariable int id) {
        return repo.findById(id).map(h -> {
            h.setName(newHero.getName());
            return repo.save(h);
        }).orElseGet(() -> {
            newHero.setId(id);
            return repo.save(newHero);
        });
    }

    @GetMapping("/heroes/{id}")
    Hero oneHero(@PathVariable int id) {
        return repo.findById(id).orElseThrow(() -> new HeroNotFoundException(id));
    }

    @GetMapping("/heroes/")
    List<Hero> searchHero(@RequestParam(name = "name", required = true) String name) {
        List<Hero> heroesSearch = new ArrayList<Hero>();
        for (Hero h : repo.findAll()) {
            if (h.getName().contains(name)) {
                heroesSearch.add(h);
            }
        }

        return heroesSearch;
    }

    @DeleteMapping("/heroes/{id}")
    void deleteHero(@PathVariable int id) {
        repo.deleteById(id);
    }

}
