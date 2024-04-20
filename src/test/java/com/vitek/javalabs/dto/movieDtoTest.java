import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.vitek.javalabs.model.Actor;
import com.vitek.javalabs.model.Director;
import com.vitek.javalabs.model.Genre;
import com.vitek.javalabs.model.Year;

class MovieDtoTest {

    @Test
    void testMovieDtoConstructorAndGetters() {
        Long id = 1L;
        String title = "Movie";
        String language = "English";
        String poster = "poster";
        String runtime = "120";
        String plot = "plot";
        Year year = new Year();
        Set<Genre> genres = new HashSet<>();
        Set<Actor> actors = new HashSet<>();
        Set<Director> directors = new HashSet<>();

        MovieDto movieDto = new MovieDto();
        movieDto.setId(id);
        movieDto.setTitle(title);
        movieDto.setLanguage(language);
        movieDto.setPoster(poster);
        movieDto.setRuntime(runtime);
        movieDto.setPlot(plot);
        movieDto.setYear(year);
        movieDto.setGenres(genres);
        movieDto.setActors(actors);
        movieDto.setDirectors(directors);

        assertEquals(id, movieDto.getId());
        assertEquals(title, movieDto.getTitle());
        assertEquals(language, movieDto.getLanguage());
        assertEquals(poster, movieDto.getPoster());
        assertEquals(runtime, movieDto.getRuntime());
        assertEquals(plot, movieDto.getPlot());
        assertEquals(year, movieDto.getYear());
        assertEquals(genres, movieDto.getGenres());
        assertEquals(actors, movieDto.getActors());
        assertEquals(directors, movieDto.getDirectors());
    }

    @Test
    void testMovieDtoSetterAndGetters() {
        MovieDto movieDto = new MovieDto();

        Long id = 1L;
        String title = "Movie";
        String language = "English";
        String poster = "poster";
        String runtime = "120";
        String plot = "plot";
        Year year = new Year();
        Set<Genre> genres = new HashSet<>();
        Set<Actor> actors = new HashSet<>();
        Set<Director> directors = new HashSet<>();

        movieDto.setId(id);
        movieDto.setTitle(title);
        movieDto.setLanguage(language);
        movieDto.setPoster(poster);
        movieDto.setRuntime(runtime);
        movieDto.setPlot(plot);
        movieDto.setYear(year);
        movieDto.setGenres(genres);
        movieDto.setActors(actors);
        movieDto.setDirectors(directors);

        assertEquals(id, movieDto.getId());
        assertEquals(title, movieDto.getTitle());
        assertEquals(language, movieDto.getLanguage());
        assertEquals(poster, movieDto.getPoster());
        assertEquals(runtime, movieDto.getRuntime());
        assertEquals(plot, movieDto.getPlot());
        assertEquals(year, movieDto.getYear());
        assertEquals(genres, movieDto.getGenres());
        assertEquals(actors, movieDto.getActors());
        assertEquals(directors, movieDto.getDirectors());
    }
}
