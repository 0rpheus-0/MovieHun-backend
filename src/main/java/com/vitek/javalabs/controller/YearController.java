package com.vitek.javalabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitek.javalabs.dto.YearDto;
import com.vitek.javalabs.service.YearService;

@RestController
@RequestMapping("/year")
public class YearController {

    private YearService yearService;

    @Autowired
    public YearController(YearService yearService) {
        this.yearService = yearService;
    }

    @GetMapping
    public ResponseEntity<List<YearDto>> getAllYears() {
        return ResponseEntity.ok(yearService.getAllYears());
    }

    @GetMapping("/{id}")
    public ResponseEntity<YearDto> getYearById(@PathVariable Long id) {
        return ResponseEntity.of(yearService.getYearById(id));
    }

    @PostMapping
    public ResponseEntity<YearDto> createYear(@RequestBody YearDto year) {
        return ResponseEntity.ok(yearService.createYear(year));
    }

    @PutMapping("/{id}")
    public ResponseEntity<YearDto> updateYear(@PathVariable Long id, @RequestBody YearDto year) {
        return ResponseEntity.ok(yearService.updateYear(id, year));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteYearById(@PathVariable Long id) {
        yearService.deleteYearBuId(id);
        return ResponseEntity.ok().build();
    }
}
