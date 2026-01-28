package com.vilelo.movieservice.controller;

import com.vilelo.movieservice.domain.Genre;
import com.vilelo.movieservice.dto.MovieDto;
import com.vilelo.movieservice.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieDto> getAll(){
        return this.service.getAllMovies();
    }

    @GetMapping("{genre}")
    public List<MovieDto> getAllByGenre(@PathVariable Genre genre){
        return this.service.getAllMoviesByGenre(genre);
    }
}
