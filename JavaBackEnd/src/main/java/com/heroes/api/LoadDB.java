package com.heroes.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(HeroesRepository repo) {
        return args -> {
            log.info("Preloading " + repo.save(new Hero("Aragorn")));
            log.info("Preloading " + repo.save(new Hero("Gandalf")));
            log.info("Preloading " + repo.save(new Hero("Frodo")));
            log.info("Preloading " + repo.save(new Hero("Legolas")));
            log.info("Preloading " + repo.save(new Hero("Gimli")));
            log.info("Preloading " + repo.save(new Hero("Bilbo")));
            log.info("Preloading " + repo.save(new Hero("Saruman")));
            log.info("Preloading " + repo.save(new Hero("Fili")));
            log.info("Preloading " + repo.save(new Hero("Dwalin")));
            log.info("Preloading " + repo.save(new Hero("Samwise")));
        };
    }
    
}
