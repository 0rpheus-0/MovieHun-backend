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
@RequestMapping("/actor")
public class ActorController {

    private HumanService actorService;

    @Autowired
    public ActorController(HumanService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<Human>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllHumans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Human> getActorById(@PathVariable Long id) {
        return ResponseEntity.of(actorService.getHumanById(id));
    }

    @PostMapping
    public ResponseEntity<Human> createActor(@RequestBody Human actor) {
        return ResponseEntity.ok(actorService.createHuman(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Human> updateActor(@PathVariable Long id, @RequestBody Human actor) {
        return ResponseEntity.ok(actorService.updateHuman(id, actor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActorById(@PathVariable Long id) {
        actorService.deleteHumanBuId(id);
        return ResponseEntity.ok().build();
    }
}