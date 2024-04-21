package com.vitek.javalabs.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.service.MovieService;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Test
    void getAllMovies() {
        List<MovieDto> movies = new ArrayList<>();
        movies.add(new MovieDto());
        movies.add(new MovieDto());

        when(movieService.getAllMovies()).thenReturn(movies);

        ResponseEntity<List<MovieDto>> response = movieController.getAllMovies();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());

        verify(movieService, times(1)).getAllMovies();
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void getMovieById() {
        Long movieId = 1L;
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movieId);
        movieDto.setTitle("Test Movie");

        when(movieService.getMovieById(movieId)).thenReturn(Optional.of(movieDto));

        ResponseEntity<MovieDto> response = movieController.getMovieById(movieId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movieDto, response.getBody());

        verify(movieService, times(1)).getMovieById(movieId);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void getMoviesByGenre() {
        Long genreId = 1L;
        List<MovieDto> movies = new ArrayList<>();
        movies.add(new MovieDto());
        movies.add(new MovieDto());

        when(movieService.getMoviesByGenre(genreId)).thenReturn(movies);

        ResponseEntity<List<MovieDto>> response = movieController.getMoviesByGenre(genreId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());

        verify(movieService, times(1)).getMoviesByGenre(genreId);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void getMoviesByActor() {
        Long actorId = 1L;
        List<MovieDto> movies = new ArrayList<>();
        movies.add(new MovieDto());
        movies.add(new MovieDto());

        when(movieService.getMoviesByActor(actorId)).thenReturn(movies);

        ResponseEntity<List<MovieDto>> response = movieController.getMoviesByActor(actorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());

        verify(movieService, times(1)).getMoviesByActor(actorId);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void getMoviesByDirector() {
        Long directorId = 1L;
        List<MovieDto> movies = new ArrayList<>();
        movies.add(new MovieDto());
        movies.add(new MovieDto());

        when(movieService.getMoviesByDirector(directorId)).thenReturn(movies);

        ResponseEntity<List<MovieDto>> response = movieController.getMoviesByDirector(directorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());

        verify(movieService, times(1)).getMoviesByDirector(directorId);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void getMoviesByYear() {
        Long yearId = 1L;
        List<MovieDto> movies = new ArrayList<>();
        movies.add(new MovieDto());
        movies.add(new MovieDto());

        when(movieService.getMoviesByYear(yearId)).thenReturn(movies);

        ResponseEntity<List<MovieDto>> response = movieController.getMoviesByYear(yearId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());

        verify(movieService, times(1)).getMoviesByYear(yearId);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void createMovie() {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle("Test Movie");

        when(movieService.createMovie(movieDto)).thenReturn(movieDto);

        ResponseEntity<MovieDto> response = movieController.createMovie(movieDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movieDto, response.getBody());

        verify(movieService, times(1)).createMovie(movieDto);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void createMovieByName() {
        String name = "Test Movie";
        MovieDto movieDto = new MovieDto();

        ResponseEntity<MovieDto> expectedResponse = ResponseEntity.ok(movieDto);

        when(movieService.createMovieByName(name)).thenReturn(movieDto);

        ResponseEntity<MovieDto> response = movieController.createMovieByName(name);

        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
        assertEquals(expectedResponse.getBody(), response.getBody());
        verify(movieService, times(1)).createMovieByName(name);
    }

    @Test
    void updateMovie() {
        Long movieId = 1L;
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movieId);
        movieDto.setTitle("Updated Movie");

        when(movieService.updateMovie(movieId, movieDto)).thenReturn(movieDto);

        ResponseEntity<MovieDto> response = movieController.updateMovie(movieId, movieDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movieDto, response.getBody());

        verify(movieService, times(1)).updateMovie(movieId, movieDto);
        verifyNoMoreInteractions(movieService);
    }

    @Test
    void deleteMovieById() {
        Long movieId = 1L;

        ResponseEntity<Void> response = movieController.deleteMovieById(movieId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(movieService, times(1)).deleteMovieBuId(movieId);
        verifyNoMoreInteractions(movieService);
    }
}
