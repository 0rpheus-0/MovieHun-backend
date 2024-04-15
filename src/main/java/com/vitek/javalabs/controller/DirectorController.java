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

import com.vitek.javalabs.dto.DirectorDto;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.service.DirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable Long id) {
        return ResponseEntity.of(directorService.getDirectorById(id));
    }

    @PostMapping
    public ResponseEntity<DirectorDto> createDirector(@RequestBody DirectorDto director) {
        return ResponseEntity.ok(directorService.createDirector(director));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDto> updateDirector(@PathVariable Long id, @RequestBody DirectorDto director) {
        return ResponseEntity.ok(directorService.updateDirector(id, director));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectorById(@PathVariable Long id) {
        directorService.deleteDirectorBuId(id);
        return ResponseEntity.ok().build();
    }
}
