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
import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.service.impl.ActorServiceImpl;
import com.vitek.javalabs.utils.ActorMapping;

@ExtendWith(MockitoExtension.class)
class ActorServiceImplTest {
    @Mock
    private ActorRepository actorRepository;

    @Mock
    private EntityCache<ActorDto> actorCache;

    @Mock
    private ActorMapping actorMapping;

    @InjectMocks
    private ActorServiceImpl actorService;

    @Test
    void getAllActors() {
        List<Actor> actorEntities = new ArrayList<>();
        Actor actorEntity1 = new Actor();
        actorEntity1.setId(1L);
        actorEntity1.setName("Actor 1");
        Actor actorEntity2 = new Actor();
        actorEntity2.setId(2L);
        actorEntity2.setName("Actor 2");
        actorEntities.add(actorEntity1);
        actorEntities.add(actorEntity2);

        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor 1");

        when(actorRepository.findAll()).thenReturn(actorEntities);
        when(actorMapping.toDto(any(Actor.class))).thenReturn(actorDto);

        List<ActorDto> actors = actorService.getAllActors();

        assertNotNull(actors);
        assertEquals(2, actors.size());
        assertEquals("Actor 1", actors.get(0).getName());
    }

    @Test
    void getActorById() {
        Actor actorEntity = new Actor();
        actorEntity.setId(1L);
        actorEntity.setName("Actor");
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");

        when(actorCache.get(1L)).thenReturn(Optional.empty());
        when(actorRepository.findById(1L)).thenReturn(Optional.of(actorEntity));
        when(actorMapping.toDto(actorEntity)).thenReturn(actorDto);

        Optional<ActorDto> actor = actorService.getActorById(1L);

        assertTrue(actor.isPresent());
        assertEquals("Actor", actor.get().getName());

        verify(actorCache, times(1)).put(1L, actorDto);
    }

    @Test
    void testGetActorById_CacheHit() {
        // Arrange
        Long actorId = 1L;
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");
        when(actorCache.get(actorId)).thenReturn(Optional.of(actorDto));

        // Act
        Optional<ActorDto> result = actorService.getActorById(actorId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(actorDto, result.get());
        verify(actorRepository, never()).findById(anyLong());
        verify(actorCache, never()).put(anyLong(), any(ActorDto.class));
    }

    @Test
    void testGetActorById_CacheMiss() {
        // Arrange
        Long actorId = 1L;
        when(actorCache.get(actorId)).thenReturn(Optional.empty());

        Actor actorEntity = new Actor();
        actorEntity.setId(1L);
        actorEntity.setName("Actor");
        when(actorRepository.findById(actorId)).thenReturn(Optional.of(actorEntity));

        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");
        when(actorMapping.toDto(actorEntity)).thenReturn(actorDto);

        // Act
        Optional<ActorDto> result = actorService.getActorById(actorId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(actorDto, result.get());
        verify(actorCache).put(actorId, actorDto);
    }

    @Test
    void testGetActorById_NotFound() {
        // Arrange
        Long actorId = 1L;
        when(actorCache.get(actorId)).thenReturn(Optional.empty());
        when(actorRepository.findById(actorId)).thenReturn(Optional.empty());

        // Act
        Optional<ActorDto> result = actorService.getActorById(actorId);

        // Assert
        assertFalse(result.isPresent());
        verify(actorCache, never()).put(anyLong(), any(ActorDto.class));
    }

    @Test
    void createActor() {
        Actor actorEntity = new Actor();
        actorEntity.setId(1L);
        actorEntity.setName("Actor");
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");

        when(actorMapping.toEntity(actorDto)).thenReturn(actorEntity);
        when(actorRepository.save(actorEntity)).thenReturn(actorEntity);
        when(actorMapping.toDto(actorEntity)).thenReturn(actorDto);

        ActorDto createdActor = actorService.createActor(actorDto);

        assertNotNull(createdActor);
        assertEquals("Actor", createdActor.getName());

        verify(actorCache, times(1)).put(1L, actorDto);
    }

    @Test
    void updateActor() {
        Actor actorEntity = new Actor();
        actorEntity.setId(1L);
        actorEntity.setName("Actor");
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");

        when(actorMapping.toEntity(actorDto)).thenReturn(actorEntity);
        when(actorRepository.save(actorEntity)).thenReturn(actorEntity);
        when(actorMapping.toDto(actorEntity)).thenReturn(actorDto);

        ActorDto updatedActor = actorService.updateActor(1L, actorDto);

        assertNotNull(updatedActor);
        assertEquals("Actor", updatedActor.getName());

        verify(actorCache, times(1)).put(1L, actorDto);
    }

    @Test
    void deleteActorById() {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("Actor");

        Void result = actorService.deleteActorBuId(1L);

        assertNull(result);
        verify(actorCache, times(1)).remove(1L);
        verify(actorRepository, times(1)).deleteById(1L);
    }
}
