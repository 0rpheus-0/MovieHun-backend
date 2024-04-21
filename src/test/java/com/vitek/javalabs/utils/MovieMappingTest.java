package com.vitek.javalabs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.model.Movie;

@ExtendWith(MockitoExtension.class)
class MovieMappingTest {
    private final MovieMapping movieMapping = new MovieMapping();

    @Test
    void toDto() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Test Movie");

        MovieDto movieDto = movieMapping.toDto(movie);

        assertEquals(movie.getId(), movieDto.getId());
        assertEquals(movie.getTitle(), movieDto.getTitle());
    }

    @Test
    void toEntity() {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(1L);
        movieDto.setTitle("Test Movie");

        Movie movie = movieMapping.toEntity(movieDto);

        assertEquals(movieDto.getId(), movie.getId());
        assertEquals(movieDto.getTitle(), movie.getTitle());
    }
}
