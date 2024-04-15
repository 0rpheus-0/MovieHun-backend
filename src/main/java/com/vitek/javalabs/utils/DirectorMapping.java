package com.vitek.javalabs.utils;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorMapping {
    public DirectorDto toDto(Director entity) {
        DirectorDto dto = new DirectorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Director toEntity(DirectorDto dto) {
        Director entity = new Director();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
