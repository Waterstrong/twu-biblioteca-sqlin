package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Movie;

public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieService = new MovieService();
    }

    @Test
    public void should_be_able_to_get_movie_list() {
        List<Movie> movies = movieService.listItems();

        assertFalse(movies.isEmpty());
        Movie movie = movies.get(0);
        assertEquals(movie.getId(), "M0001");
        assertEquals(movie.getName(), "The Runner");
        assertEquals(movie.getYear(), "2015");
        assertEquals(movie.getDirector(), "Austin Stark");
        assertEquals(movie.getRating(), 8.5, 0.000001);
    }

    @Test
    public void should_be_able_to_checkout_movie() {
        String message = movieService.checkoutItem("M0002", "R0001");
        assertEquals(message, "Thank you! Enjoy the movie!");
    }
}
