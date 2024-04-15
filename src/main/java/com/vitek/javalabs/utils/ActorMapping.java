package com.vitek.javalabs.utils;

import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.model.Actor;

public class ActorMapping {
    public ActorDto toDto(Actor entity) {
        ActorDto dto = new ActorDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Actor toEntity(ActorDto dto) {
        Actor entity = new Actor();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
