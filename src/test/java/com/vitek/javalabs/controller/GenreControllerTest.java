package com.vitek.javalabs.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.service.GenreService;

@ExtendWith(MockitoExtension.class)
class GenreControllerTest {
    @Mock
    private GenreService genreService;

    @InjectMocks
    private GenreController genreController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllGenres() {
        List<GenreDto> genres = new ArrayList<>();
        genres.add(new GenreDto());
        genres.add(new GenreDto());

        when(genreService.getAllGenres()).thenReturn(genres);

        ResponseEntity<List<GenreDto>> response = genreController.getAllGenres();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(genres, response.getBody());

        verify(genreService, times(1)).getAllGenres();
        verifyNoMoreInteractions(genreService);
    }

    @Test
    void getGenreById() {
        Long genreId = 1L;
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genreId);
        genreDto.setName("Test Genre");

        when(genreService.getGenreById(genreId)).thenReturn(Optional.of(genreDto));

        ResponseEntity<GenreDto> response = genreController.getGenreById(genreId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(genreDto, response.getBody());

        verify(genreService, times(1)).getGenreById(genreId);
        verifyNoMoreInteractions(genreService);
    }

    @Test
    void bulkCreateGenre() {
        List<GenreDto> genres = new ArrayList<>();
        genres.add(new GenreDto());
        genres.add(new GenreDto());
        String expectedResponse = "Bulk creation successful";

        when(genreService.bulkCreateGenre(genres)).thenReturn(expectedResponse);

        ResponseEntity<String> responseEntity = genreController.bulkCreateGenre(genres);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
        verify(genreService, times(1)).bulkCreateGenre(genres);
    }

    @Test
    void createGenre() {
        GenreDto genreDto = new GenreDto();
        genreDto.setName("Test Genre");

        when(genreService.createGenre(genreDto)).thenReturn(genreDto);

        ResponseEntity<GenreDto> response = genreController.createGenre(genreDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(genreDto, response.getBody());

        verify(genreService, times(1)).createGenre(genreDto);
        verifyNoMoreInteractions(genreService);
    }

    @Test
    void updateGenre() {
        Long genreId = 1L;
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genreId);
        genreDto.setName("Updated Genre");

        when(genreService.updateGenre(genreId, genreDto)).thenReturn(genreDto);

        ResponseEntity<GenreDto> response = genreController.updateGenre(genreId, genreDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(genreDto, response.getBody());

        verify(genreService, times(1)).updateGenre(genreId, genreDto);
        verifyNoMoreInteractions(genreService);
    }

    @Test
    void deleteGenreById() {
        Long genreId = 1L;

        ResponseEntity<Void> response = genreController.deleteGenreById(genreId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(genreService, times(1)).deleteGenreBuId(genreId);
        verifyNoMoreInteractions(genreService);
    }
}
