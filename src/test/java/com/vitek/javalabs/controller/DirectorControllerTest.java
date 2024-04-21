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

import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.service.DirectorService;

@ExtendWith(MockitoExtension.class)
class DirectorControllerTest {
    @Mock
    private DirectorService directorService;

    @InjectMocks
    private DirectorController directorController;

    @Test
    void getAllDirectors() {
        List<DirectorDto> directors = new ArrayList<>();
        directors.add(new DirectorDto());
        directors.add(new DirectorDto());

        when(directorService.getAllDirectors()).thenReturn(directors);

        ResponseEntity<List<DirectorDto>> response = directorController.getAllDirectors();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(directors, response.getBody());

        verify(directorService, times(1)).getAllDirectors();
        verifyNoMoreInteractions(directorService);
    }

    @Test
    void getDirectorById() {
        Long directorId = 1L;
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(directorId);
        directorDto.setName("Test Director");

        when(directorService.getDirectorById(directorId)).thenReturn(Optional.of(directorDto));

        ResponseEntity<DirectorDto> response = directorController.getDirectorById(directorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(directorDto, response.getBody());

        verify(directorService, times(1)).getDirectorById(directorId);
        verifyNoMoreInteractions(directorService);
    }

    @Test
    void createDirector() {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setName("Test Director");

        when(directorService.createDirector(directorDto)).thenReturn(directorDto);

        ResponseEntity<DirectorDto> response = directorController.createDirector(directorDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(directorDto, response.getBody());

        verify(directorService, times(1)).createDirector(directorDto);
        verifyNoMoreInteractions(directorService);
    }

    @Test
    void updateDirector() {
        Long directorId = 1L;
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(directorId);
        directorDto.setName("Updated Director");

        when(directorService.updateDirector(directorId, directorDto)).thenReturn(directorDto);

        ResponseEntity<DirectorDto> response = directorController.updateDirector(directorId, directorDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(directorDto, response.getBody());

        verify(directorService, times(1)).updateDirector(directorId, directorDto);
        verifyNoMoreInteractions(directorService);
    }

    @Test
    void deleteDirectorById() {
        Long directorId = 1L;

        ResponseEntity<Void> response = directorController.deleteDirectorById(directorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(directorService, times(1)).deleteDirectorBuId(directorId);
        verifyNoMoreInteractions(directorService);
    }
}
