package com.vitek.javalabs.utils;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.dto.GenreDto;
import com.vitek.javalabs.model.Genre;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GenreMapping {

    public GenreDto toDto(Genre entity) {
        GenreDto dto = new GenreDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Genre toEntity(GenreDto dto) {
        Genre entity = new Genre();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
