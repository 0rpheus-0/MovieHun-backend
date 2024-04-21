package com.vitek.javalabs.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.service.YearService;

@ExtendWith(MockitoExtension.class)
class YearControllerTest {
    @Mock
    private YearService yearService;

    @InjectMocks
    private YearController yearController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllYears() {
        List<YearDto> years = new ArrayList<>();
        years.add(new YearDto());
        years.add(new YearDto());

        when(yearService.getAllYears()).thenReturn(years);

        ResponseEntity<List<YearDto>> response = yearController.getAllYears();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(years, response.getBody());

        verify(yearService, times(1)).getAllYears();
        verifyNoMoreInteractions(yearService);
    }

    @Test
    void getYearById() {
        Long yearId = 1L;
        YearDto yearDto = new YearDto();
        yearDto.setId(yearId);
        yearDto.setYearRel("2020");

        when(yearService.getYearById(yearId)).thenReturn(Optional.of(yearDto));

        ResponseEntity<YearDto> response = yearController.getYearById(yearId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(yearDto, response.getBody());

        verify(yearService, times(1)).getYearById(yearId);
        verifyNoMoreInteractions(yearService);
    }

    @Test
    void createYear() {
        YearDto yearDto = new YearDto();
        yearDto.setYearRel("2020");

        when(yearService.createYear(yearDto)).thenReturn(yearDto);

        ResponseEntity<YearDto> response = yearController.createYear(yearDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(yearDto, response.getBody());

        verify(yearService, times(1)).createYear(yearDto);
        verifyNoMoreInteractions(yearService);
    }

    @Test
    void updateYear() {
        Long yearId = 1L;
        YearDto yearDto = new YearDto();
        yearDto.setId(yearId);
        yearDto.setYearRel("2020");

        when(yearService.updateYear(yearId, yearDto)).thenReturn(yearDto);

        ResponseEntity<YearDto> response = yearController.updateYear(yearId, yearDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(yearDto, response.getBody());

        verify(yearService, times(1)).updateYear(yearId, yearDto);
        verifyNoMoreInteractions(yearService);
    }

    @Test
    void deleteYearById() {
        Long yearId = 1L;

        ResponseEntity<Void> response = yearController.deleteYearById(yearId);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(yearService, times(1)).deleteYearBuId(yearId);
        verifyNoMoreInteractions(yearService);
    }
}
