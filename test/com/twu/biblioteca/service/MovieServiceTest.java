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

    @Test
    public void should_not_checkout_movie_when_movie_not_exists() {
        String message = movieService.checkoutItem("M000X", "R0001");
        assertEquals(message, "That movie is not available.");
    }

    @Test
    public void should_not_checkout_movie_when_movie_is_already_checked_out() {
        movieService.checkoutItem("M0001", "R0001");
        String message = movieService.checkoutItem("M0001", "R0002");
        assertEquals(message, "That movie is not available.");
    }

    @Test
    public void should_be_able_to_return_movie() {
        movieService.checkoutItem("M0001", "R0001");
        String message = movieService.returnCheckedItem("M0001");
        assertEquals(message, "Thank you for returning the movie.");
    }

    @Test
    public void should_not_be_able_to_return_movie() throws Exception {
        String message = movieService.returnCheckedItem("M000X");
        assertEquals(message, "That is not a valid movie to return.");
    }
}