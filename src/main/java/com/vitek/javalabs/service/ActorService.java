package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.dto.ActorDto;

public interface ActorService {

    public List<ActorDto> getAllActors();

    public Optional<ActorDto> getActorById(Long id);

    public ActorDto createActor(ActorDto actor);

    public ActorDto updateActor(Long id, ActorDto actor);

    public Void deleteActorBuId(Long id);
}
