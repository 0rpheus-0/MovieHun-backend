package com.vitek.javalabs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitek.javalabs.model.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByName(String name);
}
