package com.vitek.javalabs.service;

import java.util.Optional;

import com.vitek.javalabs.model.Genre;

public interface GenreService {

    public Optional<Genre> getGenreById(Long id);

    public Genre createGenre(Genre genre);

    public Genre updateGenre(Long id, Genre genre);

    public Void deleteGenreBuId(Long id);
}
