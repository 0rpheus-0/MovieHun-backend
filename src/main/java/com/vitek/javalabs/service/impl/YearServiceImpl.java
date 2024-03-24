package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.YearService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class YearServiceImpl implements YearService {

    private YearRepository years;
    private EntityCache<Year> yearCache;

    public List<Year> getAllYears() {
        return years.findAll();
    }

    public Optional<Year> getYearById(Long id) {
        Optional<Year> year = yearCache.get(id);
        if (!year.isPresent()) {
            year = years.findById(id);
            if (year.isPresent())
                yearCache.put(id, year.get());
        }
        return year;
    }

    public Year createYear(Year year) {
        yearCache.put(year.getId(), year);
        return years.save(year);
    }

    public Year updateYear(Long id, Year year) {
        year.setId(id);
        yearCache.put(id, year);
        return years.save(year);
    }

    public Void deleteYearBuId(Long id) {
        yearCache.remove(id);
        years.deleteById(id);
        return null;
    }
}
