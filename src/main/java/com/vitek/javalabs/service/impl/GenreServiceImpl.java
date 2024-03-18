package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.service.GenreService;

import jakarta.persistence.EntityManager;

@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;
    private EntityManager entityManager;

    public GenreServiceImpl(GenreRepository genreRepository, EntityManager entityManager) {
        this.genreRepository = genreRepository;
        this.entityManager = entityManager;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre genre) {
        genre.setId(id);
        genreRepository.saveAndFlush(genre);
        Genre managerGenre = entityManager.find(Genre.class, genre.getId());
        entityManager.refresh(managerGenre);
        return managerGenre;
    }

    public Void deleteGenreBuId(Long id) {
        genreRepository.deleteById(id);
        return null;
    }
}
