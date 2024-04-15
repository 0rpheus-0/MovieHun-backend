package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.repository.ActorRepository;
import com.vitek.javalabs.service.ActorService;
import com.vitek.javalabs.utils.ActorMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actors;
    private EntityCache<ActorDto> actorCache;
    private ActorMapping actorMapping;

    public List<ActorDto> getAllActors() {
        return actors.findAll().stream().map(x -> actorMapping.toDto(x)).toList();
    }

    public Optional<ActorDto> getActorById(Long id) {
        Optional<ActorDto> actor = actorCache.get(id);
        if (!actor.isPresent()) {
            Optional<Actor> actorEntity = actors.findById(id);
            if (actorEntity.isPresent()) {
                actor = Optional.of(actorMapping.toDto(actorEntity.get()));
                actorCache.put(id, actor.get());
            }
        }
        return actor;
    }

    public ActorDto createActor(ActorDto actor) {
        actorCache.put(actor.getId(), actor);
        return actorMapping.toDto(actors.save(actorMapping.toEntity(actor)));
    }

    public ActorDto updateActor(Long id, ActorDto actor) {
        actor.setId(id);
        actorCache.put(id, actor);
        return actorMapping.toDto(actors.save(actorMapping.toEntity(actor)));
    }

    public Void deleteActorBuId(Long id) {
        actorCache.remove(id);
        actors.deleteById(id);
        return null;
    }
}
