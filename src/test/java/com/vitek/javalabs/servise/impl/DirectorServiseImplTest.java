package com.vitek.javalabs.servise.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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
import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.repository.DirectorRepository;
import com.vitek.javalabs.service.impl.DirectorServiceImpl;
import com.vitek.javalabs.utils.DirectorMapping;

@ExtendWith(MockitoExtension.class)
class DirectorServiseImplTest {
    @Mock
    private DirectorRepository directorRepository;
    @Mock
    private EntityCache<DirectorDto> directorCache;
    @Mock
    private DirectorMapping directorMapping;
    @InjectMocks
    private DirectorServiceImpl directorService;

    @Test
    void getAllDirectors() {
        List<Director> directorEntities = new ArrayList<>();
        Director directorEntity1 = new Director();
        directorEntity1.setId(1L);
        directorEntity1.setName("Director 1");
        Director directorEntity2 = new Director();
        directorEntity2.setId(2L);
        directorEntity2.setName("Director 2");
        directorEntities.add(directorEntity1);
        directorEntities.add(directorEntity2);

        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Director 1");

        when(directorRepository.findAll()).thenReturn(directorEntities);
        when(directorMapping.toDto(any(Director.class))).thenReturn(directorDto);

        List<DirectorDto> directors = directorService.getAllDirectors();

        assertNotNull(directors);
        assertEquals(2, directors.size());
        assertEquals("Director 1", directors.get(0).getName());
    }

    @Test
    void getDirectorById() {
        Director directorEntity = new Director();
        directorEntity.setId(1L);
        directorEntity.setName("Director");
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Director");

        when(directorCache.get(1L)).thenReturn(Optional.empty());
        when(directorRepository.findById(1L)).thenReturn(Optional.of(directorEntity));
        when(directorMapping.toDto(directorEntity)).thenReturn(directorDto);

        Optional<DirectorDto> director = directorService.getDirectorById(1L);

        assertTrue(director.isPresent());
        assertEquals("Director", director.get().getName());
    }

    @Test
    void createDirector() {
        Director directorEntity = new Director();
        directorEntity.setId(1L);
        directorEntity.setName("Director");
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Director");

        when(directorMapping.toEntity(directorDto)).thenReturn(directorEntity);
        when(directorRepository.save(directorEntity)).thenReturn(directorEntity);
        when(directorMapping.toDto(directorEntity)).thenReturn(directorDto);

        DirectorDto createdDirector = directorService.createDirector(directorDto);

        assertNotNull(createdDirector);
        assertEquals("Director", createdDirector.getName());
    }

    @Test
    void updateDirector() {
        Director directorEntity = new Director();
        directorEntity.setId(1L);
        directorEntity.setName("Director");
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Director");

        when(directorMapping.toEntity(directorDto)).thenReturn(directorEntity);
        when(directorRepository.save(directorEntity)).thenReturn(directorEntity);
        when(directorMapping.toDto(directorEntity)).thenReturn(directorDto);

        DirectorDto updatedDirector = directorService.updateDirector(1L, directorDto);

        assertNotNull(updatedDirector);
        assertEquals("Director", updatedDirector.getName());
    }

    @Test
    void deleteDirectorById() {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Director");

        Void result = directorService.deleteDirectorBuId(1L);

        assertNull(result);
        verify(directorCache, times(1)).remove(1L);
        verify(directorRepository, times(1)).deleteById(1L);
    }
}
