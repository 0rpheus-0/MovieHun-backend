package com.vitek.javalabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitek.javalabs.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.id = :genre")
    List<Movie> findMoviesByGenre(@Param("genre") Long genreId);

    // @Query("SELECT m FROM Movie m JOIN m.years y WHERE y.id = :year")
    // List<Movie> findMoviesByYear(@Param("year") Long yearId);
}
