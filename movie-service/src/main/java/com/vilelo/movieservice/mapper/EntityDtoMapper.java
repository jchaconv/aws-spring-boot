package com.vilelo.movieservice.mapper;

import com.vilelo.movieservice.dto.MovieDto;
import com.vilelo.movieservice.entity.Movie;

public class EntityDtoMapper {

    public static MovieDto movieEntityToDto(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getGenre()
        );
    }

}
