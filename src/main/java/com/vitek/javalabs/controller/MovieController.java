package com.vitek.javalabs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitek.javalabs.payload.Movie;
import com.vitek.javalabs.service.InformService;

@RestController
public class MovieController {

    private final InformService informService;

    public MovieController(InformService informService) {
        this.informService = informService;
    }

    @GetMapping("movie")
    public ResponseEntity<Movie> getInform(@RequestParam(value = "name") String name) {
        Movie movie = informService.getInfotm(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
