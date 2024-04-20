package com.vitek.javalabs.servise.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        private MovieRepository movieRepository;
        @Mock
        private YearRepository yearRepository;
        @Mock
        private GenreRepository ganreRepository;
        @Mock
        private ActorRepository actorRepository;
        @Mock
        private DirectorRepository directorRepository;
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
                List<Movie> movieEntities = new ArrayList<>();
                Movie movieEntity1 = new Movie();
                movieEntity1.setId(1L);
                movieEntity1.setTitle("Movie 1");
                movieEntities.add(movieEntity1);
                Movie movieEntity2 = new Movie();
                movieEntity2.setId(2L);
                movieEntity2.setTitle("Movie 2");
                movieEntities.add(movieEntity2);

                List<MovieDto> movieDtos = new ArrayList<>();
                MovieDto movieDto1 = new MovieDto();
                movieDto1.setId(1L);
                movieDto1.setTitle("Movie 1");
                MovieDto movieDto2 = new MovieDto();
                movieDto2.setId(2L);
                movieDto2.setTitle("Movie 2");
                movieDtos.add(movieDto1);
                movieDtos.add(movieDto2);

                when(movieRepository.findAll()).thenReturn(movieEntities);
                Mockito.when(movieMapping.toDto(movieEntity1)).thenReturn(movieDto1);
                Mockito.when(movieMapping.toDto(movieEntity2)).thenReturn(movieDto2);

                List<MovieDto> movies = movieService.getAllMovies();

                assertNotNull(movies);
                assertEquals(2, movies.size());
                assertEquals(movieDtos, movieService.getAllMovies());
        }

        @Test
        void getMovieById() {
                Movie movieEntity = new Movie();
                movieEntity.setId(1L);
                movieEntity.setTitle("Movie");
                MovieDto movieDto = new MovieDto();
                movieDto.setId(1L);
                movieDto.setTitle("Movie");

                when(movieCache.get(1L)).thenReturn(Optional.empty());
                when(movieRepository.findById(1L)).thenReturn(Optional.of(movieEntity));
                when(movieMapping.toDto(movieEntity)).thenReturn(movieDto);

                Optional<MovieDto> movie = movieService.getMovieById(1L);

                assertTrue(movie.isPresent());
                assertEquals("Movie", movie.get().getTitle());

                verify(movieCache, times(1)).put(1L, movieDto);
        }

        @Test
        void getMoviesByGenre() {
                List<Movie> movieEntities = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Genre> genreSet = new HashSet<>();
                Genre genre = new Genre();
                genre.setId(1L);
                genre.setName("genre");
                genreSet.add(genre);
                movieEntities.add(movie);

                List<MovieDto> MovieDtos = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Set<Genre> expectedGenreSet = new HashSet<>();
                Genre expectedGenre = new Genre();
                expectedGenre.setId(1L);
                expectedGenre.setName("genre");
                expectedGenreSet.add(expectedGenre);
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                MovieDtos.add(movieDto);

                when(movieRepository.findMoviesByGenre(1L)).thenReturn(movieEntities);
                when(movieMapping.toDto(movie)).thenReturn(movieDto);
                assertEquals(MovieDtos, movieService.getMoviesByGenre(1L));
        }

        @Test
        void getMoviesByActor() {
                List<Movie> movieEntities = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Actor> actorSet = new HashSet<>();
                Actor actor = new Actor();
                actor.setId(1L);
                actor.setName("Actor");
                actorSet.add(actor);
                movieEntities.add(movie);

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

                when(movieRepository.findMoviesByActor(1L)).thenReturn(movieEntities);
                when(movieMapping.toDto(movie)).thenReturn(movieDto);
                assertEquals(expectedMovieDtoList, movieService.getMoviesByActor(1L));
        }

        @Test
        void getMoviesByDirector() {
                List<Movie> movieEntities = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Set<Director> directorSet = new HashSet<>();
                Director director = new Director();
                director.setId(1L);
                director.setName("Director");
                directorSet.add(director);
                movieEntities.add(movie);

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

                Mockito.when(movieRepository.findMoviesByDirector(1L)).thenReturn(movieEntities);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByDirector(1L));
        }

        @Test
        void getMoviesByYear() {
                List<Movie> movieEntities = new ArrayList<>();
                Movie movie = new Movie();
                movie.setId(1L);
                movie.setTitle("Movie");
                Year year = new Year();
                year.setId(1L);
                year.setYearRel("Year");
                movieEntities.add(movie);

                List<MovieDto> expectedMovieDtoList = new ArrayList<>();
                Movie expectedMovie = new Movie();
                expectedMovie.setId(1L);
                expectedMovie.setTitle("Movie");
                Year expectedYear = new Year();
                expectedYear.setId(1L);
                expectedYear.setYearRel("Year");
                MovieDto movieDto = movieMapping.toDto(expectedMovie);
                expectedMovieDtoList.add(movieDto);

                Mockito.when(movieRepository.findMoviesByYear(1L)).thenReturn(movieEntities);
                Mockito.when(movieMapping.toDto(movie)).thenReturn(movieDto);
                Assertions.assertEquals(expectedMovieDtoList, movieService.getMoviesByYear(1L));
        }

        // @Test
        // void testCreateMovie() {
        // Movie movieEntity = new Movie();
        // movieEntity.setId(1L);
        // movieEntity.setTitle("Movie");
        // MovieDto movieDto = new MovieDto();
        // movieDto.setId(1L);
        // movieDto.setTitle("Movie");

        // when(movieMapping.toEntity(any(MovieDto.class))).thenReturn(movieEntity);
        // when(movieRepository.save(movieEntity)).thenReturn(movieEntity);
        // when(movieMapping.toDto(movieEntity)).thenReturn(movieDto);

        // MovieDto createdMovieDto = movieService.createMovie(movieDto);

        // assertNotNull(createdMovieDto);
        // assertEquals("Movie", createdMovieDto.getTitle());

        // verify(movieMapping, times(1)).toEntity(movieDto);
        // verify(movieRepository, times(1)).save(movieEntity);
        // verify(movieMapping, times(1)).toDto(movieEntity);
        // }

        // @Test
        // void testUpdateMovie() {
        // Movie movieEntity = new Movie();
        // movieEntity.setId(1L);
        // movieEntity.setTitle("Movie");
        // MovieDto movieDto = new MovieDto();
        // movieDto.setId(1L);
        // movieDto.setTitle("Movie");

        // when(movieMapping.toEntity(any(MovieDto.class))).thenReturn(movieEntity);
        // when(movieRepository.save(movieEntity)).thenReturn(movieEntity);
        // when(movieMapping.toDto(movieEntity)).thenReturn(movieDto);

        // MovieDto resultMovieDto = movieService.updateMovie(1L, movieDto);

        // assertNotNull(resultMovieDto);
        // assertEquals("Movie", resultMovieDto.getTitle());

        // verify(movieMapping, times(1)).toEntity(movieDto);
        // verify(movieRepository, times(1)).save(movieEntity);
        // verify(movieMapping, times(1)).toDto(movieEntity);
        // }

        @Test
        void DeleteMovie() {
                MovieDto movieDto = new MovieDto();
                movieDto.setId(1L);
                movieDto.setTitle("Movie");

                Void result = movieService.deleteMovieBuId(1L);

                assertNull(result);
                verify(movieCache, times(1)).remove(1L);
                verify(movieRepository, times(1)).deleteById(1L);
        }
}
