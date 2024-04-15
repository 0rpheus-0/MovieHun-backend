package com.vitek.javalabs.utils;

import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.model.Year;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class YearMapping {
    public YearDto toDto(Year entity) {
        YearDto dto = new YearDto();
        dto.setId(entity.getId());
        dto.setYearRel(entity.getYearRel());
        return dto;
    }

    public Year toEntity(YearDto dto) {
        Year entity = new Year();
        entity.setId(dto.getId());
        entity.setYearRel(dto.getYearRel());
        return entity;
    }
}
