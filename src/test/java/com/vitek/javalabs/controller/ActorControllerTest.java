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

import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.service.ActorService;

@ExtendWith(MockitoExtension.class)
class ActorControllerTest {
    @Mock
    private ActorService actorService;

    @InjectMocks
    private ActorController actorController;

    @Test
    void getAllActors() {
        List<ActorDto> actors = new ArrayList<>();
        actors.add(new ActorDto());
        actors.add(new ActorDto());

        when(actorService.getAllActors()).thenReturn(actors);

        ResponseEntity<List<ActorDto>> response = actorController.getAllActors();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(actors, response.getBody());

        verify(actorService, times(1)).getAllActors();
        verifyNoMoreInteractions(actorService);
    }

    @Test
    void getActorById() {
        Long actorId = 1L;
        ActorDto actorDto = new ActorDto();
        actorDto.setId(actorId);
        actorDto.setName("Test Actor");

        when(actorService.getActorById(actorId)).thenReturn(Optional.of(actorDto));

        ResponseEntity<ActorDto> response = actorController.getActorById(actorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(actorDto, response.getBody());

        verify(actorService, times(1)).getActorById(actorId);
        verifyNoMoreInteractions(actorService);
    }

    @Test
    void createActor() {
        ActorDto actorDto = new ActorDto();
        actorDto.setName("Test Actor");

        when(actorService.createActor(actorDto)).thenReturn(actorDto);

        ResponseEntity<ActorDto> response = actorController.createActor(actorDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(actorDto, response.getBody());

        verify(actorService, times(1)).createActor(actorDto);
        verifyNoMoreInteractions(actorService);
    }

    @Test
    void updateActor() {
        Long actorId = 1L;
        ActorDto actorDto = new ActorDto();
        actorDto.setId(actorId);
        actorDto.setName("Updated Actor");

        when(actorService.updateActor(actorId, actorDto)).thenReturn(actorDto);

        ResponseEntity<ActorDto> response = actorController.updateActor(actorId, actorDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(actorDto, response.getBody());

        verify(actorService, times(1)).updateActor(actorId, actorDto);
        verifyNoMoreInteractions(actorService);
    }

    @Test
    void deleteActorById() {
        Long actorId = 1L;

        ResponseEntity<Void> response = actorController.deleteActorById(actorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(actorService, times(1)).deleteActorBuId(actorId);
        verifyNoMoreInteractions(actorService);
    }
}
