package com.vitek.javalabs.service;

import java.util.List;
import java.util.Optional;

import com.vitek.javalabs.model.Human;

public interface HumanService {

    public List<Human> getAllHumans();

    public Optional<Human> getHumanById(Long id);

    public Human createHuman(Human actor);

    public Human updateHuman(Long id, Human actor);

    public Void deleteHumanBuId(Long id);
}
