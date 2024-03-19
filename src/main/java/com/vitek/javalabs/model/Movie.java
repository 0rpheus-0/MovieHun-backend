package com.vitek.javalabs.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;
    private String actors;
    private String language;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Year year;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "movies_genres", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
            @JoinColumn(name = "genre_id") })
    private Set<Genre> genres;

}
