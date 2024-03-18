package com.vitek.javalabs.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.getGenres().add(this);
    }

    public void removeMovie(Long movieId) {
        Movie movie = this.movies.stream().filter(t -> t.getId().equals(movieId)).findFirst().orElse(null);
        if (movie != null) {
            this.movies.remove(movie);
            movie.getGenres().remove(this);
        }
    }
}
