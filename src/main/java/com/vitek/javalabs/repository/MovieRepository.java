package com.vitek.javalabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitek.javalabs.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
