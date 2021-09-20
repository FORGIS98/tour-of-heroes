package com.heroes.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/hero")
    Hero newHero(@RequestBody Hero newHero) {
        return repo.save(newHero);
    }

    @GetMapping("/hero/{id}")
    Hero oneHero(@PathVariable int id) {
        return repo.findById(id).orElseThrow(() -> new HeroNotFoundException(id));
    }

    @DeleteMapping("/hero/{id}")
    void deleteHero(@PathVariable int id) {
        repo.deleteById(id);
    }

}
