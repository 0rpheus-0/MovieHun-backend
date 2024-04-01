package com.vitek.javalabs.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.model.Movie;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.payload.MovieAdv;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.repository.MovieRepository;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.MovieAdvService;
import com.vitek.javalabs.service.MovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movies;
    private YearRepository years;
    private GenreRepository ganres;
    private ActorRepository actors;
    private MovieAdvService movieAdvService;
    private EntityCache<Movie> movieCache;

    public List<Movie> getAllMovies() {
        return movies.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        Optional<Movie> movie = movieCache.get(id);
        if (!movie.isPresent()) {
            movie = movies.findById(id);
            if (movie.isPresent())
                movieCache.put(id, movie.get());
        }
        return movie;
    }

    public List<Movie> getMoviesByGenre(Long id) {
        return movies.findMoviesByGenre(id);
    }

    public List<Movie> getMoviesByYear(Long id) {
        return movies.findMoviesByYear(id);
    }

    public Movie createMovie(Movie movie) {
        movie.setYear(years.findByYearRel(movie.getYear().getYearRel()).orElse(movie.getYear()));
        movie.setGenres(
                movie.getGenres()
                        .stream()
                        .map(x -> ganres.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movie.setActors(
                movie.getActors()
                        .stream()
                        .map(x -> actors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieCache.put(movie.getId(), movie);
        return movies.save(movie);
    }

    public Movie createMovieByName(String name) {
        Movie movie = new Movie();
        MovieAdv movieAdv = movieAdvService.getInfotm(name);
        movie.setTitle(movieAdv.getTitle());
        movie.setDirector(movieAdv.getDirector());
        movie.setLanguage(movieAdv.getLanguage());
        movie.setPoster(movieAdv.getPoster());

        Year year = new Year();
        year.setYearRel(movieAdv.getYear());
        movie.setYear(year);

        String genreStr = movieAdv.getGenre();
        Set<Genre> setGenre = new HashSet<>();

        String[] wordsG = genreStr.split("[,\\s]+");
        for (String wordG : wordsG) {
            Genre genre = new Genre();
            genre.setName(wordG.trim());
            setGenre.add(genre);
        }
        movie.setGenres(setGenre);

        String actorStr = movieAdv.getActors();
        Set<Actor> setActor = new HashSet<>();

        String[] wordsA = actorStr.split("[,\\s]+");
        for (String wordA : wordsA) {
            Actor actor = new Actor();
            actor.setName(wordA.trim());
            setActor.add(actor);
        }
        movie.setActors(setActor);

        createMovie(movie);

        return movie;
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        movie.setYear(years.findByYearRel(movie.getYear().getYearRel()).orElse(movie.getYear()));
        movie.setGenres(
                movie.getGenres()
                        .stream()
                        .map(x -> ganres.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movie.setActors(
                movie.getActors()
                        .stream()
                        .map(x -> actors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieCache.put(id, movie);
        return movies.save(movie);
    }

    public Void deleteMovieBuId(Long id) {
        movieCache.remove(id);
        movies.deleteById(id);
        return null;
    }

}
