package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.model.Actor;

public interface ActorService {

    public List<Actor> getAllActors();

    public Optional<Actor> getActorById(Long id);

    public Actor createActor(Actor actor);

    public Actor updateActor(Long id, Actor actor);

    public Void deleteActorBuId(Long id);
}
