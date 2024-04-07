package com.vitek.javalabs.model;

import java.util.Set;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {
        @Id
        @GeneratedValue
        private Long id;
        private String title;
        private String language;
        private String poster;
        private String runtime;
        private String plot;

        @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        private Year year;

        @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        @JoinTable(name = "movies_genres", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "genre_id") })
        private Set<Genre> genres;

        @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        @JoinTable(name = "movies_actors", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "actor_id") })
        private Set<Actor> actors;

        @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        @JoinTable(name = "movies_directors", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "director_id") })
        private Set<Director> directors;

}
