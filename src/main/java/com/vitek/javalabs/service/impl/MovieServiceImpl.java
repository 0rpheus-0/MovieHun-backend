package com.vitek.javalabs.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.model.Movie;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.payload.MovieAdv;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.repository.DirectorRepository;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.repository.MovieRepository;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.MovieAdvService;
import com.vitek.javalabs.service.MovieService;
import com.vitek.javalabs.utils.MovieMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movies;
    private YearRepository years;
    private GenreRepository ganres;
    private ActorRepository actors;
    private DirectorRepository directors;
    private MovieAdvService movieAdvService;
    private EntityCache<MovieDto> movieCache;
    private MovieMapping movieMapping;

    public List<MovieDto> getAllMovies() {
        return movies.findAll().stream().map(x -> movieMapping.toDto(x)).toList();
    }

    public Optional<MovieDto> getMovieById(Long id) {
        Optional<MovieDto> movie = movieCache.get(id);
        if (!movie.isPresent()) {
            Optional<Movie> movieEntity = movies.findById(id);
            if (movieEntity.isPresent()) {
                movie = Optional.of(movieMapping.toDto(movieEntity.get()));
                movieCache.put(id, movie.get());
            }
        }
        return movie;
    }

    public List<MovieDto> getMoviesByGenre(Long id) {
        return movies.findMoviesByGenre(id).stream().map(x -> movieMapping.toDto(x)).toList();
    }

    public List<MovieDto> getMoviesByActor(Long id) {
        return movies.findMoviesByActor(id).stream().map(x -> movieMapping.toDto(x)).toList();
    }

    public List<MovieDto> getMoviesByDirector(Long id) {
        return movies.findMoviesByDirector(id).stream().map(x -> movieMapping.toDto(x)).toList();
    }

    public List<MovieDto> getMoviesByYear(Long id) {
        return movies.findMoviesByYear(id).stream().map(x -> movieMapping.toDto(x)).toList();
    }

    public MovieDto createMovie(MovieDto movie) {
        Movie movieEntity = movieMapping.toEntity(movie);
        movieEntity.setYear(years.findByYearRel(movieEntity.getYear().getYearRel()).orElse(movieEntity.getYear()));
        movieEntity.setGenres(
                movieEntity.getGenres()
                        .stream()
                        .map(x -> ganres.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieEntity.setActors(
                movieEntity.getActors()
                        .stream()
                        .map(x -> actors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieEntity.setDirectors(
                movieEntity.getDirectors()
                        .stream()
                        .map(x -> directors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movies.save(movieEntity);
        movie = movieMapping.toDto(movieEntity);
        movieCache.put(movie.getId(), movie);
        return movie;
    }

    public Movie createMovieByName(String name) {
        Movie movie = new Movie();
        MovieAdv movieAdv = movieAdvService.getInfotm(name);
        movie.setTitle(movieAdv.getTitle());
        movie.setLanguage(movieAdv.getLanguage());
        movie.setPoster(movieAdv.getPoster());
        movie.setRuntime(movieAdv.getRuntime());
        movie.setPlot(movieAdv.getPlot());

        Year year = new Year();
        year.setYearRel(movieAdv.getYear());
        movie.setYear(year);

        String genreStr = movieAdv.getGenre();
        Set<Genre> setGenre = new HashSet<>();

        String[] wordsG = genreStr.split(", ");
        for (String wordG : wordsG) {
            Genre genre = new Genre();
            genre.setName(wordG.trim());
            setGenre.add(genre);
        }
        movie.setGenres(setGenre);

        String actorStr = movieAdv.getActors();
        Set<Actor> setActor = new HashSet<>();

        String[] wordsA = actorStr.split(", ");
        for (String wordA : wordsA) {
            Actor actor = new Actor();
            actor.setName(wordA.trim());
            setActor.add(actor);
        }
        movie.setActors(setActor);

        String directorStr = movieAdv.getDirector();
        Set<Director> setDirector = new HashSet<>();

        String[] wordsD = directorStr.split(", ");
        for (String wordD : wordsD) {
            Director director = new Director();
            director.setName(wordD.trim());
            setDirector.add(director);
        }
        movie.setDirectors(setDirector);

        createMovie(movieMapping.toDto(movie));

        return movie;// пофиксить
    }

    public MovieDto updateMovie(Long id, MovieDto movie) {
        Movie movieEntity = movieMapping.toEntity(movie);
        movieEntity.setId(id);
        movieEntity.setYear(years.findByYearRel(movieEntity.getYear().getYearRel()).orElse(movieEntity.getYear()));
        movieEntity.setGenres(
                movieEntity.getGenres()
                        .stream()
                        .map(x -> ganres.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieEntity.setActors(
                movieEntity.getActors()
                        .stream()
                        .map(x -> actors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movieEntity.setDirectors(
                movieEntity.getDirectors()
                        .stream()
                        .map(x -> directors.findByName(x.getName()).orElse(x))
                        .collect(Collectors.toSet()));
        movies.save(movieEntity);
        movie = movieMapping.toDto(movieEntity);
        movieCache.put(movie.getId(), movie);
        return movie;
    }

    public Void deleteMovieBuId(Long id) {
        movieCache.remove(id);
        movies.deleteById(id);
        return null;
    }

}
