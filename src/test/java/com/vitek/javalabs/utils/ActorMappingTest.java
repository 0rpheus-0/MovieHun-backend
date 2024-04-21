package com.vitek.javalabs.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vitek.javalabs.dto.ActorDto;
import com.vitek.javalabs.model.Actor;

@ExtendWith(MockitoExtension.class)
class ActorMappingTest {
    private final ActorMapping actorMapping = new ActorMapping();

    @Test
    void toDto() {
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setName("John Doe");

        ActorDto actorDto = actorMapping.toDto(actor);

        assertEquals(actor.getId(), actorDto.getId());
        assertEquals(actor.getName(), actorDto.getName());
    }

    @Test
    void toEntity() {
        ActorDto actorDto = new ActorDto();
        actorDto.setId(1L);
        actorDto.setName("John Doe");

        Actor actor = actorMapping.toEntity(actorDto);

        assertEquals(actorDto.getId(), actor.getId());
        assertEquals(actorDto.getName(), actor.getName());
    }
}
