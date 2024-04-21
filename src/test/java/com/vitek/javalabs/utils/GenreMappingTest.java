package com.vitek.javalabs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.model.Genre;

@ExtendWith(MockitoExtension.class)
class GenreMappingTest {
    private final GenreMapping genreMapping = new GenreMapping();

    @Test
    void toDto() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Action");

        GenreDto genreDto = genreMapping.toDto(genre);

        assertEquals(genre.getId(), genreDto.getId());
        assertEquals(genre.getName(), genreDto.getName());
    }

    @Test
    void toEntity() {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Action");

        Genre genre = genreMapping.toEntity(genreDto);

        assertEquals(genreDto.getId(), genre.getId());
        assertEquals(genreDto.getName(), genre.getName());
    }
}
