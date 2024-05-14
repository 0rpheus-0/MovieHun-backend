package com.vitek.javalabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitek.javalabs.aop.RequestStats;
import com.vitek.javalabs.dto.MovieDto;
import com.vitek.javalabs.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("/movie")
@RequestStats
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(id));
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<List<MovieDto>> getMoviesByActor(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMoviesByActor(id));
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<List<MovieDto>> getMoviesByDirector(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMoviesByDirector(id));
    }

    @GetMapping("/year/{id}")
    public ResponseEntity<List<MovieDto>> getMoviesByYear(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMoviesByYear(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.of(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    @PostMapping("/name")
    public ResponseEntity<MovieDto> createMovieByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(movieService.createMovieByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @RequestBody MovieDto movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieBuId(id);
        return ResponseEntity.ok().build();
    }

}
