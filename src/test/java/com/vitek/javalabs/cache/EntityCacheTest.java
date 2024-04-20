package com.vitek.javalabs.cache;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityCacheTest {
    private EntityCache<Object> cache;

    @BeforeEach
    public void setUp() {
        cache = new EntityCache<>();
    }

    @Test
    void get() {
        Long key = 1L;
        Object value = "value";
        cache.put(key, value);
        Optional<Object> result = cache.get(key);
        Assertions.assertEquals(value, result.get());
    }

    @Test
    void put() {
        Long key = 1L;
        Object value = "value";
        cache.put(key, value);
        Optional<Object> result = cache.get(key);
        Assertions.assertEquals(value, result.get());
    }

    @Test
    void remove() {
        Long key = 1L;
        Object value = "value";

        cache.put(key, value);
        cache.remove(1L);
        Optional<Object> result = cache.get(key);

        Assertions.assertEquals(Optional.empty(), result);
    }
}
