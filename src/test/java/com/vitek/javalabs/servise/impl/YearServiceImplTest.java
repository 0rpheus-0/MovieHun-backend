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
import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.impl.YearServiceImpl;
import com.vitek.javalabs.utils.YearMapping;

@ExtendWith(MockitoExtension.class)
class YearServiceImplTest {
    @Mock
    private YearRepository yearRepository;
    @Mock
    private EntityCache<YearDto> yearCache;
    @Mock
    private YearMapping yearMapping;
    @InjectMocks
    private YearServiceImpl yearService;

    @Test
    void getAllYears() {
        List<Year> yearEntities = new ArrayList<>();
        Year yearEntity1 = new Year();
        yearEntity1.setId(1L);
        yearEntity1.setYearRel("2020");
        Year yearEntity2 = new Year();
        yearEntity2.setId(2L);
        yearEntity2.setYearRel("2021");
        yearEntities.add(yearEntity1);
        yearEntities.add(yearEntity2);

        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2020");

        when(yearRepository.findAll()).thenReturn(yearEntities);
        when(yearMapping.toDto(any(Year.class))).thenReturn(yearDto);

        List<YearDto> years = yearService.getAllYears();

        assertNotNull(years);
        assertEquals(2, years.size());
        assertEquals("2020", years.get(0).getYearRel());
    }

    @Test
    void getYearById() {
        Year yearEntity = new Year();
        yearEntity.setId(1L);
        yearEntity.setYearRel("2020");
        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2020");

        when(yearCache.get(1L)).thenReturn(Optional.empty());
        when(yearRepository.findById(1L)).thenReturn(Optional.of(yearEntity));
        when(yearMapping.toDto(yearEntity)).thenReturn(yearDto);

        Optional<YearDto> year = yearService.getYearById(1L);

        assertTrue(year.isPresent());
        assertEquals("2020", year.get().getYearRel());

        verify(yearCache, times(1)).put(1L, yearDto);
    }

    @Test
    void createYear() {
        Year yearEntity = new Year();
        yearEntity.setId(1L);
        yearEntity.setYearRel("2020");
        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2020");

        when(yearMapping.toEntity(yearDto)).thenReturn(yearEntity);
        when(yearRepository.save(yearEntity)).thenReturn(yearEntity);
        when(yearMapping.toDto(yearEntity)).thenReturn(yearDto);

        YearDto createdYear = yearService.createYear(yearDto);

        assertNotNull(createdYear);
        assertEquals("2020", createdYear.getYearRel());

        verify(yearCache, times(1)).put(1L, yearDto);
    }

    @Test
    void updateYear() {
        Year yearEntity = new Year();
        yearEntity.setId(1L);
        yearEntity.setYearRel("2020");
        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2020");

        when(yearMapping.toEntity(yearDto)).thenReturn(yearEntity);
        when(yearRepository.save(yearEntity)).thenReturn(yearEntity);
        when(yearMapping.toDto(yearEntity)).thenReturn(yearDto);

        YearDto updatedYear = yearService.updateYear(1L, yearDto);

        assertNotNull(updatedYear);
        assertEquals("2020", updatedYear.getYearRel());

        verify(yearCache, times(1)).put(1L, yearDto);
    }

    @Test
    void deleteYearById() {
        YearDto yearDto = new YearDto();
        yearDto.setId(1L);
        yearDto.setYearRel("2020");

        Void result = yearService.deleteYearBuId(1L);

        assertNull(result);
        verify(yearCache, times(1)).remove(1L);
        verify(yearRepository, times(1)).deleteById(1L);
    }
}
