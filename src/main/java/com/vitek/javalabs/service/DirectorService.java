package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;

public interface DirectorService {

    public List<DirectorDto> getAllDirectors();

    public Optional<DirectorDto> getDirectorById(Long id);

    public DirectorDto createDirector(DirectorDto director);

    public DirectorDto updateDirector(Long id, DirectorDto director);

    public Void deleteDirectorBuId(Long id);
}
