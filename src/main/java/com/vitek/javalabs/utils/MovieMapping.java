package com.vitek.javalabs.utils;

import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.model.Movie;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovieMapping {
    public MovieDto toDto(Movie entity) {
        MovieDto dto = new MovieDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setLanguage(entity.getLanguage());
        dto.setPoster(entity.getPoster());
        dto.setRuntime(entity.getRuntime());
        dto.setPlot(entity.getPlot());
        dto.setYear(entity.getYear());
        dto.setGenres(entity.getGenres());
        dto.setActors(entity.getActors());
        dto.setDirectors(entity.getDirectors());
        return dto;
    }

    public Movie toEntity(MovieDto dto) {
        Movie entity = new Movie();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setLanguage(dto.getLanguage());
        entity.setPoster(dto.getPoster());
        entity.setRuntime(dto.getRuntime());
        entity.setPlot(dto.getPlot());
        entity.setYear(dto.getYear());
        entity.setGenres(dto.getGenres());
        entity.setActors(dto.getActors());
        entity.setDirectors(dto.getDirectors());
        return entity;
    }
}
