package com.vitek.javalabs.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieAdvTest {
    @Test
    void testGettersAndSetters() {
        String title = "Test Movie";
        String year = "2021";
        String released = "2021-01-01";
        String runtime = "120 min";
        String genre = "Action, Thriller";
        String director = "John Doe";
        String writer = "Jane Smith";
        String actors = "John Smith, Jane Doe";
        String plot = "Test plot";
        String language = "English";
        String country = "United States";
        Float imdbRating = 7.5f;
        String type = "Movie";
        String poster = "https://example.com/poster.jpg";

        MovieAdv movieAdv = new MovieAdv();
        movieAdv.setTitle(title);
        movieAdv.setYear(year);
        movieAdv.setReleased(released);
        movieAdv.setRuntime(runtime);
        movieAdv.setGenre(genre);
        movieAdv.setDirector(director);
        movieAdv.setWriter(writer);
        movieAdv.setActors(actors);
        movieAdv.setPlot(plot);
        movieAdv.setLanguage(language);
        movieAdv.setCountry(country);
        movieAdv.setImdbRating(imdbRating);
        movieAdv.setType(type);
        movieAdv.setPoster(poster);

        String actualTitle = movieAdv.getTitle();
        String actualYear = movieAdv.getYear();
        String actualReleased = movieAdv.getReleased();
        String actualRuntime = movieAdv.getRuntime();
        String actualGenre = movieAdv.getGenre();
        String actualDirector = movieAdv.getDirector();
        String actualWriter = movieAdv.getWriter();
        String actualActors = movieAdv.getActors();
        String actualPlot = movieAdv.getPlot();
        String actualLanguage = movieAdv.getLanguage();
        String actualCountry = movieAdv.getCountry();
        Float actualImdbRating = movieAdv.getImdbRating();
        String actualType = movieAdv.getType();
        String actualPoster = movieAdv.getPoster();

        assertEquals(title, actualTitle);
        assertEquals(year, actualYear);
        assertEquals(released, actualReleased);
        assertEquals(runtime, actualRuntime);
        assertEquals(genre, actualGenre);
        assertEquals(director, actualDirector);
        assertEquals(writer, actualWriter);
        assertEquals(actors, actualActors);
        assertEquals(plot, actualPlot);
        assertEquals(language, actualLanguage);
        assertEquals(country, actualCountry);
        assertEquals(imdbRating, actualImdbRating);
        assertEquals(type, actualType);
        assertEquals(poster, actualPoster);
    }
}
