package com.vitek.javalabs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenreTest {
    private Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        genre.setId(id);
        assertEquals(id, genre.getId());
    }

    @Test
    void testNameGetterAndSetter() {
        String name = "Genre";
        genre.setName(name);
        assertEquals(name, genre.getName());
    }
}