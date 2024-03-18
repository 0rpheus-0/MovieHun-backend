package com.vitek.javalabs.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.model.Movie;
import com.vitek.javalabs.repository.MovieRepository;
import com.vitek.javalabs.service.MovieService;

import jakarta.persistence.EntityManager;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private EntityManager entityManager;

    public MovieServiceImpl(MovieRepository movieRepository, EntityManager entityManager) {
        this.movieRepository = movieRepository;
        this.entityManager = entityManager;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        movieRepository.saveAndFlush(movie);
        Movie managerMovie = entityManager.find(Movie.class, movie.getId());
        entityManager.refresh(managerMovie);
        return managerMovie;
    }

    public Void deleteMovieBuId(Long id) {
        movieRepository.deleteById(id);
        return null;
    }

}
