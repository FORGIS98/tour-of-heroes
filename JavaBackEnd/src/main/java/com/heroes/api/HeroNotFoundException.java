package com.heroes.api;

public class HeroNotFoundException extends RuntimeException {
    HeroNotFoundException(int id) {
        super("Could not find hero " + id);
    }
}
