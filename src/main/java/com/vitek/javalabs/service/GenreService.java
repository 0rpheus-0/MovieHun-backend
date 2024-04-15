package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.dto.GenreDto;

public interface GenreService {

    public List<GenreDto> getAllGenres();

    public Optional<GenreDto> getGenreById(Long id);

    public GenreDto createGenre(GenreDto genre);

    public GenreDto updateGenre(Long id, GenreDto genre);

    public Void deleteGenreBuId(Long id);
}
