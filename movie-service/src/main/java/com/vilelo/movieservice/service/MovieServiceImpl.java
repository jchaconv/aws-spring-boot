package com.vilelo.movieservice.service;

import com.vilelo.movieservice.domain.Genre;
import com.vilelo.movieservice.dto.MovieDto;
import com.vilelo.movieservice.mapper.EntityDtoMapper;
import com.vilelo.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(EntityDtoMapper::movieEntityToDto)
                .toList();
    }

    @Override
    public List<MovieDto> getAllMoviesByGenre(Genre genre) {
        return movieRepository.findByGenre(genre)
                .stream()
                .map(EntityDtoMapper::movieEntityToDto)
                .toList();
    }

}
