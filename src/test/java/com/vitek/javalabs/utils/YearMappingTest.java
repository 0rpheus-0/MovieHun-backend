package com.vitek.javalabs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.model.Year;

@ExtendWith(MockitoExtension.class)
class YearMappingTest {
    private final YearMapping yearMapping = new YearMapping();

    @Test
    void toDto() {
        Year year = new Year();
        year.setId(1L);
        year.setYearRel("2022");

        YearDto yearDto = yearMapping.toDto(year);

        assertEquals(year.getId(), yearDto.getId());
        assertEquals(year.getYearRel(), yearDto.getYearRel());
    }

    @Test
    void toEntity() {
        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2022");

        Year year = yearMapping.toEntity(yearDto);

        assertEquals(yearDto.getId(), year.getId());
        assertEquals(yearDto.getYearRel(), year.getYearRel());
    }
}
