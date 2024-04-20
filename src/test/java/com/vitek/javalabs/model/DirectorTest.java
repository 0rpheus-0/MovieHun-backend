package com.vitek.javalabs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectorTest {
    private Director Director;

    @BeforeEach
    void setUp() {
        Director = new Director();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        Director.setId(id);
        assertEquals(id, Director.getId());
    }

    @Test
    void testNameGetterAndSetter() {
        String name = "Director";
        Director.setName(name);
        assertEquals(name, Director.getName());
    }
}
