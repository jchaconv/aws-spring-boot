package com.vilelo.movieservice.repository;

import com.vilelo.movieservice.domain.Genre;
import com.vilelo.movieservice.dto.MovieDto;
import com.vilelo.movieservice.entity.Movie;
import com.vilelo.movieservice.service.MovieService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ComponentScan(basePackageClasses = {MovieService.class})
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Test
    void getAllMoviesByGenreFromRepository_WhenGenreIsCrime_Success() {
        List<Movie> crimeMovies = movieRepository.findByGenre(Genre.CRIME);
        assertNotNull(crimeMovies);
        assertFalse(crimeMovies.isEmpty());
        assertTrue(crimeMovies.size() > 3);
    }

    @Test
    void getAllMovies_Success() {
        List<MovieDto> movies = movieService.getAllMovies();
        assertNotNull(movies);
        assertFalse(movies.isEmpty());
    }

    @Test
    void getAllMoviesByGenre_WhenGenreIsCrime_Success() {
        List<MovieDto> crimeMovies = movieService.getAllMoviesByGenre(Genre.CRIME);
        assertNotNull(crimeMovies);
        assertFalse(crimeMovies.isEmpty());
        assertTrue(crimeMovies.size() > 3);
    }


}