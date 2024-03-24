package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.model.Movie;

public interface MovieService {

    public List<Movie> getAllMovies();

    public Optional<Movie> getMovieById(Long id);

    public List<Movie> getMoviesByGenre(Long id);

    // public List<Movie> getMoviesByYear(Long id);

    public Movie createMovie(Movie movie);

    public Movie createMovieByName(String name);

    public Movie updateMovie(Long id, Movie movie);

    public Void deleteMovieBuId(Long id);
}
