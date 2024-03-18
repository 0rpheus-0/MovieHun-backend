package com.vitek.javalabs.service;

import java.util.Optional;

import com.vitek.javalabs.model.Year;

public interface YearService {

    public Optional<Year> getYearById(Long id);

    public Year createYear(Year year);

    public Year updateYear(Long id, Year year);

    public Void deleteYearBuId(Long id);
}