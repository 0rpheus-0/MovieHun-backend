package com.vitek.javalabs.servise.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.service.impl.GenreServiceImpl;
import com.vitek.javalabs.utils.GenreMapping;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {
    @Mock
    private GenreRepository genreRepository;
    @Mock
    private EntityCache<GenreDto> genreCache;
    @Mock
    private GenreMapping genreMapping;
    @InjectMocks
    private GenreServiceImpl genreService;

    @Test
    void getAllGenres() {
        List<Genre> genreEntities = new ArrayList<>();
        Genre genreEntity1 = new Genre();
        genreEntity1.setId(1L);
        genreEntity1.setName("Genre 1");
        Genre genreEntity2 = new Genre();
        genreEntity2.setId(2L);
        genreEntity1.setName("Genre 2");
        genreEntities.add(genreEntity1);
        genreEntities.add(genreEntity2);

        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre 1");

        when(genreRepository.findAll()).thenReturn(genreEntities);
        when(genreMapping.toDto(any(Genre.class))).thenReturn(genreDto);

        List<GenreDto> genres = genreService.getAllGenres();

        assertNotNull(genres);
        assertEquals(2, genres.size());
        assertEquals(genres, genreService.getAllGenres());
        assertEquals("Genre 1", genres.get(0).getName());
    }

    @Test
    void getGenreById() {
        Genre genreEntity = new Genre();
        genreEntity.setId(1L);
        genreEntity.setName("Genre");
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");

        when(genreRepository.findById(1L)).thenReturn(Optional.of(genreEntity));
        when(genreMapping.toDto(genreEntity)).thenReturn(genreDto);

        Optional<GenreDto> genre = genreService.getGenreById(1L);

        assertTrue(genre.isPresent());
        assertEquals("Genre", genre.get().getName());
    }

    @Test
    void testGetGenreById_CacheHit() {
        Long genreId = 1L;
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");
        when(genreCache.get(genreId)).thenReturn(Optional.of(genreDto));

        Optional<GenreDto> result = genreService.getGenreById(genreId);

        assertTrue(result.isPresent());
        assertEquals(genreDto, result.get());
        verify(genreRepository, never()).findById(anyLong());
        verify(genreCache, never()).put(anyLong(), any(GenreDto.class));
    }

    @Test
    void testGetGenreById_CacheMiss() {
        // Arrange
        Long genreId = 1L;
        when(genreCache.get(genreId)).thenReturn(Optional.empty());

        Genre genreEntity = new Genre();
        genreEntity.setId(1L);
        genreEntity.setName("Genre");
        when(genreRepository.findById(genreId)).thenReturn(Optional.of(genreEntity));

        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");
        when(genreMapping.toDto(genreEntity)).thenReturn(genreDto);

        Optional<GenreDto> result = genreService.getGenreById(genreId);

        assertTrue(result.isPresent());
        assertEquals(genreDto, result.get());
        verify(genreCache).put(genreId, genreDto);
    }

    @Test
    void testGetGenreById_NotFound() {
        Long genreId = 1L;
        when(genreCache.get(genreId)).thenReturn(Optional.empty());
        when(genreRepository.findById(genreId)).thenReturn(Optional.empty());

        Optional<GenreDto> result = genreService.getGenreById(genreId);

        assertFalse(result.isPresent());
        verify(genreCache, never()).put(anyLong(), any(GenreDto.class));
    }

    @Test
    void createGenre() {
        Genre genreEntity = new Genre();
        genreEntity.setId(1L);
        genreEntity.setName("Genre");
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");

        when(genreMapping.toEntity(genreDto)).thenReturn(genreEntity);
        when(genreRepository.save(genreEntity)).thenReturn(genreEntity);
        when(genreMapping.toDto(genreEntity)).thenReturn(genreDto);

        GenreDto createdGenre = genreService.createGenre(genreDto);

        assertNotNull(createdGenre);
        assertEquals("Genre", createdGenre.getName());
    }

    @Test
    void updateGenre() {
        Genre genreEntity = new Genre();
        genreEntity.setId(1L);
        genreEntity.setName("Genre");
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");

        when(genreMapping.toEntity(genreDto)).thenReturn(genreEntity);
        when(genreRepository.save(genreEntity)).thenReturn(genreEntity);
        when(genreMapping.toDto(genreEntity)).thenReturn(genreDto);

        GenreDto updatedGenre = genreService.updateGenre(1L, genreDto);

        assertNotNull(updatedGenre);
        assertEquals("Genre", updatedGenre.getName());
    }

    @Test
    void deleteGenreById() {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(1L);
        genreDto.setName("Genre");

        Void result = genreService.deleteGenreBuId(1L);

        assertNull(result);
        verify(genreCache, times(1)).remove(1L);
        verify(genreRepository, times(1)).deleteById(1L);
    }
}
