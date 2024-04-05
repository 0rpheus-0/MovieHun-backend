package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.model.Director;

public interface DirectorService {

    public List<Director> getAllDirectors();

    public Optional<Director> getDirectorById(Long id);

    public Director createDirector(Director director);

    public Director updateDirector(Long id, Director director);

    public Void deleteDirectorBuId(Long id);
}
