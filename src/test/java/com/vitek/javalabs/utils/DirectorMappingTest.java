package com.vitek.javalabs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;

@ExtendWith(MockitoExtension.class)
class DirectorMappingTest {

    private final DirectorMapping directorMapping = new DirectorMapping();

    @Test
    void toDto() {
        Director director = new Director();
        director.setId(1L);
        director.setName("Jane Smith");

        DirectorDto directorDto = directorMapping.toDto(director);

        assertEquals(director.getId(), directorDto.getId());
        assertEquals(director.getName(), directorDto.getName());
    }

    @Test
    void toEntity() {
        DirectorDto directorDto = new DirectorDto();
        directorDto.setId(1L);
        directorDto.setName("Jane Smith");

        Director director = directorMapping.toEntity(directorDto);

        assertEquals(directorDto.getId(), director.getId());
        assertEquals(directorDto.getName(), director.getName());
    }
}
