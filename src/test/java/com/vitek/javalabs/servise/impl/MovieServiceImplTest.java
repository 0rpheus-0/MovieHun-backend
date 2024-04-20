package com.vitek.javalabs.servise.impl;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.model.Movie;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.repository.DirectorRepository;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.repository.MovieRepository;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.MovieAdvService;
import com.vitek.javalabs.service.impl.MovieServiceImpl;
import com.vitek.javalabs.utils.MovieMapping;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {
        @Mock
        private MovieRepository movies;
        @Mock
        private YearRepository years;
        @Mock
        private GenreRepository ganres;
        @Mock
        private ActorRepository actors;
        @Mock
        private DirectorRepository directors;
        @Mock
        private MovieAdvService movieAdvService;
        @Mock
        private EntityCache<MovieDto> movieCache;
        @Mock
        private MovieMapping movieMapping;

        @InjectMocks
        private MovieServiceImpl movieService;

        @Test
        void getAllMovies() {
                List<Movie> movieList = new ArrayList<>();
                Movie movie1 = new Movie();
                movie1.setId(1L);
                movie1.setTitle("Movie 1");
                movieList.add(movie1);
                Movie movie2 = new Movie();
                movie2.setId(2L);
                movie2.setTitle("Movie 2");
                movieList.add(movie2);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                MovieDto movieDto1 = new MovieDto();
                movieDto1.setId(1L);
                movieDto1.setTitle("Movie 1");
                MovieDto movieDto2 = new MovieDto();
                movieDto2.setId(2L);
                movieDto2.setTitle("Movie 2");
                expectedMovieDtoList.add(movieDto1);
                expectedMovieDtoList.add(movieDto2);

                Mockito.when(movies.findAll()).thenReturn(movieList);
                Mockito.when(movieMapping.toDto(movie1)).thenReturn(movieDto1);
                Mockito.when(movieMapping.toDto(movie2)).thenReturn(movieDto2);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getAllMovies());

        }

        @Test
        void getMovieById() {
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");

                MovieDto movieDto = new MovieDto();
                movieDto.setId(1L);
                movieDto.setTitle("Movie");

                Mockito.when(movies.findById(1L)).thenReturn(Optional.of(movie));
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(movieDto, movieService.getMovieById(1L).get());
        }

        @Test
        void getMoviesByGenre() {
                List<Movie> movieList = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Genre> genreSet = new HashSet<>();
                Genre genre = new Genre();
                genre.setId(1L);
                genre.setName("genre");
                genreSet.add(genre);
                movieList.add(movie);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Set<Genre> expectedGenreSet = new HashSet<>();
                Genre expectedGenre = new Genre();
                expectedGenre.setId(1L);
                expectedGenre.setName("genre");
                expectedGenreSet.add(expectedGenre);
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                expectedMovieDtoList.add(movieDto);

                Mockito.when(movies.findMoviesByGenre(1L)).thenReturn(movieList);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByGenre(1L));
        }

        @Test
        void getMoviesByActor() {
                List<Movie> movieList = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Actor> actorSet = new HashSet<>();
                Actor actor = new Actor();
                actor.setId(1L);
                actor.setName("Actor");
                actorSet.add(actor);
                movieList.add(movie);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Set<Actor> expectedActorSet = new HashSet<>();
                Actor expectedActor = new Actor();
                expectedActor.setId(1L);
                expectedActor.setName("Actor");
                expectedActorSet.add(expectedActor);
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                expectedMovieDtoList.add(movieDto);

                Mockito.when(movies.findMoviesByActor(1L)).thenReturn(movieList);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByActor(1L));
        }

        @Test
        void getMoviesByDirector() {
                List<Movie> movieList = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Director> directorSet = new HashSet<>();
                Director director = new Director();
                director.setId(1L);
                director.setName("Director");
                directorSet.add(director);
                movieList.add(movie);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Set<Director> expectedDirectorSet = new HashSet<>();
                Director expectedDirector = new Director();
                expectedDirector.setId(1L);
                expectedDirector.setName("Director");
                expectedDirectorSet.add(expectedDirector);
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                expectedMovieDtoList.add(movieDto);

                Mockito.when(movies.findMoviesByDirector(1L)).thenReturn(movieList);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByDirector(1L));
        }

        @Test
        void getMoviesByYear() {
                List<Movie> movieList = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Year year = new Year();
                year.setId(1L);
                year.setYearRel("Year");
                movieList.add(movie);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Year expectedYear = new Year();
                expectedYear.setId(1L);
                expectedYear.setYearRel("Year");
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                expectedMovieDtoList.add(movieDto);

                Mockito.when(movies.findMoviesByYear(1L)).thenReturn(movieList);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByYear(1L));
        }

        // @Test
        // void createMovie() {
        // Movie movie = new Movie();
        // movie.setTitle("Movie");

        // MovieDto movieDto = new MovieDto();
        // movieDto.setTitle("Movie");

        // // Mockito.when(movies.save(movie)).thenReturn(movie);
        // Mockito.when(movieMapping.toEntity(movieDto)).thenReturn(movie);
        // Mockito.when(movies.save(movie)).thenReturn(movie);
        // Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);

        // Assertions.assertEquals(movieDto, movieService.createMovie(movieDto));
        // verify(movieCache).put(movieDto.getId(), movieDto);

        // }

}
