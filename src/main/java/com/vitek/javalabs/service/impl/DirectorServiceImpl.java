package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.repository.DirectorRepository;
import com.vitek.javalabs.service.DirectorService;
import com.vitek.javalabs.utils.DirectorMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directors;
    private EntityCache<DirectorDto> directorCache;
    private DirectorMapping directorMapping;

    public List<DirectorDto> getAllDirectors() {
        return directors.findAll().stream().map(x -> directorMapping.toDto(x)).toList();
    }

    public Optional<DirectorDto> getDirectorById(Long id) {
        Optional<DirectorDto> director = directorCache.get(id);
        if (!director.isPresent()) {
            Optional<Director> directorEntity = directors.findById(id);
            if (directorEntity.isPresent()) {
                director = Optional.of(directorMapping.toDto(directorEntity.get()));
                directorCache.put(id, director.get());
            }
        }
        return director;
    }

    public DirectorDto createDirector(DirectorDto director) {
        directorCache.put(director.getId(), director);
        return directorMapping.toDto(directors.save(directorMapping.toEntity(director)));
    }

    public DirectorDto updateDirector(Long id, DirectorDto director) {
        director.setId(id);
        directorCache.put(id, director);
        return directorMapping.toDto(directors.save(directorMapping.toEntity(director)));
    }

    public Void deleteDirectorBuId(Long id) {
        directorCache.remove(id);
        directors.deleteById(id);
        return null;
    }
}