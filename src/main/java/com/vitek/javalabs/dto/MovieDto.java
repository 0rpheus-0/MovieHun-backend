package com.vitek.javalabs.dto;

import java.util.Set;

import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.model.Year;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
    private Long id;
    private String title;
    private String language;
    private String poster;
    private String runtime;
    private String plot;
    private Year year;
    private Set<Genre> genres;
    private Set<Actor> actors;
    private Set<Director> directors;
}
