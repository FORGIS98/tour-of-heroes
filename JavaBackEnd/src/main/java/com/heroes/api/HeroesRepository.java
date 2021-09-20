package com.heroes.api;

import org.springframework.data.jpa.repository.JpaRepository;

interface HeroesRepository extends JpaRepository<Hero, Integer>{
    
}
