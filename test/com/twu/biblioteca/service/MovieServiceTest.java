package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import com.twu.biblioteca.domain.Movie;

public class MovieServiceTest {
    @Test
    public void should_be_able_to_get_movie_list() {
        MovieService movieService = new MovieService();
        List<Movie> movies = movieService.listItems();

        assertFalse(movies.isEmpty());
        Movie movie = movies.get(0);
        assertEquals(movie.getId(), "M0001");
        assertEquals(movie.getName(), "The Runner");
        assertEquals(movie.getYear(), "2015");
        assertEquals(movie.getDirector(), "Austin Stark");
        assertEquals(movie.getRating(), 8.5, 0.000001);
    }


}
