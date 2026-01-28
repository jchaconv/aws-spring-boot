package com.vilelo.movieservice.dto;

import com.vilelo.movieservice.domain.Genre;

public record MovieDto(Integer id,
                       String title,
                       Integer releaseYear,
                       Genre genre) {
}
