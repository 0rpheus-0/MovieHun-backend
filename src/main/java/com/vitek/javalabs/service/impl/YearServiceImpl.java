package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.model.Year;
import com.vitek.javalabs.repository.YearRepository;
import com.vitek.javalabs.service.YearService;

import jakarta.persistence.EntityManager;

@Service
public class YearServiceImpl implements YearService {

    private YearRepository yearRepository;
    private EntityManager entityManager;

    public YearServiceImpl(YearRepository yearRepository, EntityManager entityManager) {
        this.yearRepository = yearRepository;
        this.entityManager = entityManager;
    }

    public List<Year> getAllYears() {
        return yearRepository.findAll();
    }

    public Optional<Year> getYearById(Long id) {
        return yearRepository.findById(id);
    }

    public Year createYear(Year year) {
        return yearRepository.save(year);
    }

    public Year updateYear(Long id, Year year) {
        year.setId(id);
        yearRepository.saveAndFlush(year);
        Year managerYear = entityManager.find(Year.class, year.getId());
        entityManager.refresh(managerYear);
        return managerYear;
    }

    public Void deleteYearBuId(Long id) {
        yearRepository.deleteById(id);
        return null;
    }
}
