package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.dto.YearDto;

public interface YearService {

    public List<YearDto> getAllYears();

    public Optional<YearDto> getYearById(Long id);

    public YearDto createYear(YearDto year);

    public YearDto updateYear(Long id, YearDto year);

    public Void deleteYearBuId(Long id);
}