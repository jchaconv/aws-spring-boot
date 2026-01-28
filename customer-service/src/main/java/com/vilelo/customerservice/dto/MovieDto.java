package com.vilelo.customerservice.dto;

import com.vilelo.customerservice.domain.Genre;

public record MovieDto(Integer id,
                       String title,
                       Integer releaseYear,
                       Genre genre) {
}
