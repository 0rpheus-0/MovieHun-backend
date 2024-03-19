package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.model.Movie;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.repository.MovieRepository;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.MovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movies;
    private YearRepository years;
    private GenreRepository ganres;

    public List<Movie> getAllMovies() {
        return movies.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movies.findById(id);
    }

    public Movie createMovie(Movie movie) {
        movie.setYear(years.findByYearRel(movie.getYear().getYearRel()).orElse(movie.getYear()));
        movie.setGenres(
                movie.getGenres()
                        .stream()
                        .map(x -> ganres.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        return movies.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movies.save(movie);
    }

    public Void deleteMovieBuId(Long id) {
        movies.deleteById(id);
        return null;
    }

}
