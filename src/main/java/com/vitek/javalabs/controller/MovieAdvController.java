package com.vitek.javalabs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitek.javalabs.payload.MovieAdv;
import com.vitek.javalabs.service.MovieAdvService;

@RestController
@RequestMapping("/find")
public class MovieAdvController {

    private final MovieAdvService movieAdvService;

    public MovieAdvController(MovieAdvService informService) {
        this.movieAdvService = informService;
    }

    @GetMapping
    public ResponseEntity<MovieAdv> getInform(@RequestParam(value = "name") String name) {
        MovieAdv movie = movieAdvService.getInfotm(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
