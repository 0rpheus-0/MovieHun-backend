package com.vitek.javalabs.dto;

import java.util.Set;

import com.vitek.javalabs.model.Year;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String title;
    private Year year;
    private Set<GenreDTO> genres;
    private String director;
    private String actors;
    private String language;
}
