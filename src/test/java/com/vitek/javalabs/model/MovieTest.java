package com.vitek.javalabs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @Test
    void testIdGetterAndSetter() {
        Long id = 1L;
        movie.setId(id);
        assertEquals(id, movie.getId());
    }

    @Test
    void testTitleGetterAndSetter() {
        String title = "Movie";
        movie.setTitle(title);
        assertEquals(title, movie.getTitle());
    }

    @Test
    void testLanguageGetterAndSetter() {
        String language = "English";
        movie.setLanguage(language);
        assertEquals(language, movie.getLanguage());
    }

    @Test
    void testPosterGetterAndSetter() {
        String poster = "poster";
        movie.setPoster(poster);
        assertEquals(poster, movie.getPoster());
    }

    @Test
    void testRuntimeGetterAndSetter() {
        String runtime = "120";
        movie.setRuntime(runtime);
        assertEquals(runtime, movie.getRuntime());
    }

    @Test
    void testPlotGetterAndSetter() {
        String plot = "plot";
        movie.setPlot(plot);
        assertEquals(plot, movie.getPlot());
    }

    @Test
    void testYearGetterAndSetter() {
        Year year = new Year();
        movie.setYear(year);
        assertEquals(year, movie.getYear());
    }

    @Test
    void testGenresGetterAndSetter() {

        Set<Genre> genreSet = new HashSet<>();
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("genre");
        genreSet.add(genre);
        movie.setGenres(genreSet);
        assertEquals(genreSet, movie.getGenres());
    }

    @Test
    void testActorsGetterAndSetter() {
        Set<Actor> actorSet = new HashSet<>();
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setName("Actor");
        actorSet.add(actor);
        movie.setActors(actorSet);
        assertEquals(actorSet, movie.getActors());
    }

    @Test
    void testDirectorsGetterAndSetter() {
        Set<Director> directorSet = new HashSet<>();
        Director director = new Director();
        director.setId(1L);
        director.setName("Director");
        directorSet.add(director);
        movie.setDirectors(directorSet);
        assertEquals(directorSet, movie.getDirectors());
    }
}
