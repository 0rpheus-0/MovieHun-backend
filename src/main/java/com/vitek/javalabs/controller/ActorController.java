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

import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.service.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable Long id) {
        return ResponseEntity.of(actorService.getActorById(id));
    }

    @PostMapping
    public ResponseEntity<ActorDto> createActor(@RequestBody ActorDto actor) {
        return ResponseEntity.ok(actorService.createActor(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDto> updateActor(@PathVariable Long id, @RequestBody ActorDto actor) {
        return ResponseEntity.ok(actorService.updateActor(id, actor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActorById(@PathVariable Long id) {
        actorService.deleteActorBuId(id);
        return ResponseEntity.ok().build();
    }
}
