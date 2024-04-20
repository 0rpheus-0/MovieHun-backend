package com.vitek.javalabs.servise.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.repository.GenreRepository;
import com.vitek.javalabs.service.impl.GenreServiceImpl;
import com.vitek.javalabs.utils.GenreMapping;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    private GenreRepository genres;
    @Mock
    private EntityCache<GenreDto> genreCache;
    @Mock
    private GenreMapping genreMapping;

    @InjectMocks
    private GenreServiceImpl genreService;

    // @Test
    // void GetGenreById_ValidId() {
    //     Genre genre = new Genre();
    //     genre.setId(1L);
    //     genre.setName("Genre");

    //     Mockito.when(genres.findById(1L)).thenReturn(Optional.of(genre));

    //     // Genre result = genreService.getGenreById(1L);

    //     Assertions.assertEquals(genreDto, genreService.getGenreById(1L));
    // }

}
