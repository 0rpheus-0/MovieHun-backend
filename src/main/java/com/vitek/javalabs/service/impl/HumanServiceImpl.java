package com.vitek.javalabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vitek.javalabs.cache.EntityCache;
import com.vitek.javalabs.model.Human;
import com.vitek.javalabs.repository.HumanRepository;
import com.vitek.javalabs.service.HumanService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HumanServiceImpl implements HumanService {

    private HumanRepository humans;
    private EntityCache<Human> humanCache;

    public List<Human> getAllHumans() {
        return humans.findAll();
    }

    public Optional<Human> getHumanById(Long id) {
        Optional<Human> human = humanCache.get(id);
        if (!human.isPresent()) {
            human = humans.findById(id);
            if (human.isPresent())
                humanCache.put(id, human.get());
        }
        return human;
    }

    public Human createHuman(Human human) {
        humanCache.put(human.getId(), human);
        return humans.save(human);
    }

    public Human updateHuman(Long id, Human human) {
        human.setId(id);
        humanCache.put(id, human);
        return humans.save(human);
    }

    public Void deleteHumanBuId(Long id) {
        humanCache.remove(id);
        humans.deleteById(id);
        return null;
    }
}
