package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.YearService;
import com.vitek.javalabs.utils.YearMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class YearServiceImpl implements YearService {

    private YearRepository years;
    private EntityCache<YearDto> yearCache;
    private YearMapping yearMapping;

    public List<YearDto> getAllYears() {
        return years.findAll().stream().map(x -> yearMapping.toDto(x)).toList();
    }

    public Optional<YearDto> getYearById(Long id) {
        Optional<YearDto> year = yearCache.get(id);
        if (!year.isPresent()) {
            Optional<Year> yearEntity = years.findById(id);
            if (yearEntity.isPresent()) {
                year = Optional.of(yearMapping.toDto(yearEntity.get()));
                yearCache.put(id, year.get());
            }
        }
        return year;
    }

    public YearDto createYear(YearDto year) {
        yearCache.put(year.getId(), year);
        return yearMapping.toDto(years.save(yearMapping.toEntity(year)));
    }

    public YearDto updateYear(Long id, YearDto year) {
        year.setId(id);
        yearCache.put(id, year);
        return yearMapping.toDto(years.save(yearMapping.toEntity(year)));
    }

    public Void deleteYearBuId(Long id) {
        yearCache.remove(id);
        years.deleteById(id);
        return null;
    }
}
