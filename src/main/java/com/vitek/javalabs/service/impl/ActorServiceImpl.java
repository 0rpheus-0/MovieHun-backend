package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.service.ActorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actors;
    private EntityCache<Actor> actorCache;

    public List<Actor> getAllActors() {
        return actors.findAll();
    }

    public Optional<Actor> getActorById(Long id) {
        Optional<Actor> actor = actorCache.get(id);
        if (!actor.isPresent()) {
            actor = actors.findById(id);
            if (actor.isPresent())
                actorCache.put(id, actor.get());
        }
        return actor;
    }

    public Actor createActor(Actor actor) {
        actorCache.put(actor.getId(), actor);
        return actors.save(actor);
    }

    public Actor updateActor(Long id, Actor actor) {
        actor.setId(id);
        actorCache.put(id, actor);
        return actors.save(actor);
    }

    public Void deleteActorBuId(Long id) {
        actorCache.remove(id);
        actors.deleteById(id);
        return null;
    }
}
