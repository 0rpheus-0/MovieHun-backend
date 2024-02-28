package com.vitek.javalabs.payload;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String year;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private Float imdbRating;
    private String type;

}
