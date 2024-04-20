import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.service.MovieService;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    // @BeforeEach
    // void setUp() {
    // MockitoAnnotations.openMocks(this);
    // }

    // @Test
    // void getAllMovies() {
    // List<MovieDto> movies = new ArrayList<>();
    // movies.add(new MovieDto());
    // movies.add(new MovieDto());

    // when(movieService.getAllMovies()).thenReturn(movies);

    // ResponseEntity<List<MovieDto>> response = movieController.getAllMovies();

    // assertEquals(HttpStatus.OK, response.getStatusCode());
    // assertEquals(movies, response.getBody());

    // verify(movieService, times(1)).getAllMovies();
    // verifyNoMoreInteractions(movieService);
    // }

    // @Test
    // void getMoviesByGenre() {
    // Long genreId = 1L;
    // List<MovieDto> movies = new ArrayList<>();
    // movies.add(new MovieDto());
    // movies.add(new MovieDto());

    // when(movieService.getMoviesByGenre(genreId)).thenReturn(movies);

    // ResponseEntity<List<MovieDto>> response =
    // movieController.getMoviesByGenre(genreId);

    // assertEquals(HttpStatus.OK, response.getStatusCode());
    // assertEquals(movies, response.getBody());

    // verify(movieService, times(1)).getMoviesByGenre(genreId);
    // verifyNoMoreInteractions(movieService);
    // }

    // // Дополнительные тесты для других методов контроллера могут быть добавлены
    // // аналогичным образом

    // @Test
    // void createMovie() {
    // MovieDto movieDto = new MovieDto();
    // movieDto.setTitle("Test Movie");

    // when(movieService.createMovie(movieDto)).thenReturn(movieDto);

    // ResponseEntity<MovieDto> response = movieController.createMovie(movieDto);

    // assertEquals(HttpStatus.OK, response.getStatusCode());
    // assertEquals(movieDto, response.getBody());

    // verify(movieService, times(1)).createMovie(movieDto);
    // verifyNoMoreInteractions(movieService);
    // }

    // @Test
    // void deleteMovieById() {
    // Long movieId = 1L;

    // ResponseEntity<Void> response = movieController.deleteMovieById(movieId);

    // assertEquals(HttpStatus.OK, response.getStatusCode());

    // verify(movieService, times(1)).deleteMovieBuId(movieId);
    // verifyNoMoreInteractions(movieService);
    // }
}