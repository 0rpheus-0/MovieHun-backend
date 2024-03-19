package com.vitek.javalabs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitek.javalabs.model.Year;

public interface YearRepository extends JpaRepository<Year, Long> {
    Optional<Year> findByYearRel(String rel);
}
