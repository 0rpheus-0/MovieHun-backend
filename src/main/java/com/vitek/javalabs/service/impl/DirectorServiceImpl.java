package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.repository.DirectorRepository;
import com.vitek.javalabs.service.DirectorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directors;
    private EntityCache<Director> directorCache;

    public List<Director> getAllDirectors() {
        return directors.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        Optional<Director> director = directorCache.get(id);
        if (!director.isPresent()) {
            director = directors.findById(id);
            if (director.isPresent())
                directorCache.put(id, director.get());
        }
        return director;
    }

    public Director createDirector(Director director) {
        directorCache.put(director.getId(), director);
        return directors.save(director);
    }

    public Director updateDirector(Long id, Director director) {
        director.setId(id);
        directorCache.put(id, director);
        return directors.save(director);
    }

    public Void deleteDirectorBuId(Long id) {
        directorCache.remove(id);
        directors.deleteById(id);
        return null;
    }
}