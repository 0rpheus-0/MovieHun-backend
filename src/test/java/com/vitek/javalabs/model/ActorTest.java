package com.vitek.javalabs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActorTest {
    private Actor Actor;

    @BeforeEach
    void setUp() {
        Actor = new Actor();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        Actor.setId(id);
        assertEquals(id, Actor.getId());
    }

    @Test
    void testNameGetterAndSetter() {
        String name = "Actor";
        Actor.setName(name);
        assertEquals(name, Actor.getName());
    }
}
