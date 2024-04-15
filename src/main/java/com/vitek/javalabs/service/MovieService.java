package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.model.Movie;

public interface MovieService {

    public List<MovieDto> getAllMovies();

    public Optional<MovieDto> getMovieById(Long id);

    public List<MovieDto> getMoviesByGenre(Long id);

    public List<MovieDto> getMoviesByActor(Long id);

    public List<MovieDto> getMoviesByDirector(Long id);

    public List<MovieDto> getMoviesByYear(Long id);

    public MovieDto createMovie(MovieDto movie);

    public Movie createMovieByName(String name);

    public MovieDto updateMovie(Long id, MovieDto movie);

    public Void deleteMovieBuId(Long id);
}
