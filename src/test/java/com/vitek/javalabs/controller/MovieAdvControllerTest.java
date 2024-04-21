package com.vitek.javalabs.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vitek.javalabs.payload.MovieAdv;
import com.vitek.javalabs.service.MovieAdvService;

@ExtendWith(MockitoExtension.class)
class MovieAdvControllerTest {
    @Mock
    private MovieAdvService movieAdvService;

    @InjectMocks
    private MovieAdvController movieAdvController;

    @Test
    void getInform() {
        String movieName = "Test Movie";
        MovieAdv movie = new MovieAdv();
        movie.setTitle(movieName);

        when(movieAdvService.getInfotm(movieName)).thenReturn(movie);

        ResponseEntity<MovieAdv> response = movieAdvController.getInform(movieName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movie, response.getBody());

        verify(movieAdvService, times(1)).getInfotm(movieName);
        verifyNoMoreInteractions(movieAdvService);
    }
}
