package com.vitek.javalabs.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class EntityCache<T> {
    Map<Long, T> cache = new HashMap<>();

    private static final int MAX = 100;

    public Optional<T> get(Long key) {
        return Optional.ofNullable(cache.get(key));
    }

    public void put(Long key, T value) {
        if (cache.size() >= MAX)
            cache.clear();
        cache.put(key, value);
    }

    public void remove(Long key) {
        cache.remove(key);
    }
}