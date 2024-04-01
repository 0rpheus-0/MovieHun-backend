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

import com.vitek.javalabs.model.Human;
import com.vitek.javalabs.service.HumanService;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private HumanService directorService;

    @Autowired
    public DirectorController(HumanService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<Human>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllHumans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Human> getDirectorById(@PathVariable Long id) {
        return ResponseEntity.of(directorService.getHumanById(id));
    }

    @PostMapping
    public ResponseEntity<Human> createDirector(@RequestBody Human director) {
        return ResponseEntity.ok(directorService.createHuman(director));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Human> updateDirector(@PathVariable Long id, @RequestBody Human director) {
        return ResponseEntity.ok(directorService.updateHuman(id, director));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectorById(@PathVariable Long id) {
        directorService.deleteHumanBuId(id);
        return ResponseEntity.ok().build();
    }
}
