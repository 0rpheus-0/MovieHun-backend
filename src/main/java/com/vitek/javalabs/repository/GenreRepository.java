package com.vitek.javalabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitek.javalabs.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}