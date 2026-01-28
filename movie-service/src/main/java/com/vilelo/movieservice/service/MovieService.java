package com.vilelo.movieservice.service;

import com.vilelo.movieservice.domain.Genre;
import com.vilelo.movieservice.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    List<MovieDto> getAllMoviesByGenre(Genre genre);

}
