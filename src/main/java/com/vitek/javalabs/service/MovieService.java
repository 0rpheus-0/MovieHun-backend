package com.vitek.javalabs.service;

import java.util.Optional;
import java.util.List;

import com.vitek.javalabs.model.Movie;

public interface MovieService {

    public List<Movie> getAllMovies();

    public Optional<Movie> getMovieById(Long id);

    public Movie createMovie(Movie movie);

    public Movie updateMovie(Long id, Movie movie);

    public Void deleteMovieBuId(Long id);
}
