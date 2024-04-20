package com.vitek.javalabs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YearTest {
    private Year Year;

    @BeforeEach
    void setUp() {
        Year = new Year();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        Year.setId(id);
        assertEquals(id, Year.getId());
    }

    @Test
    void testNameGetterAndSetter() {
        String name = "2020";
        Year.setYearRel(name);
        assertEquals(name, Year.getYearRel());
    }
}
