package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        String message = movieService.checkoutItem("M0003", "333-3333");
        assertEquals(message, "Thank you! Enjoy the movie!");
    }

    @Test
    public void should_not_checkout_movie_when_movie_not_exists() {
        String message = movieService.checkoutItem("M000X", "333-3333");
        assertEquals(message, "That movie is not available.");
    }

    @Test
    public void should_not_checkout_movie_when_movie_is_already_checked_out() {
        movieService.checkoutItem("M0001", "333-3333");
        String message = movieService.checkoutItem("M0001", "111-1111");
        assertEquals(message, "That movie is not available.");
    }

    @Test
    public void should_be_able_to_return_movie() {
        movieService.checkoutItem("M0001", "333-3333");
        String message = movieService.returnCheckedItem("M0001", "333-3333");
        assertEquals(message, "Thank you for returning the movie.");
    }

    @Test
    public void should_not_return_movie_when_movie_id_is_incorrect() {
        String message = movieService.returnCheckedItem("M000X", "333-3333");
        assertEquals(message, "That is not a valid movie to return.");
    }

    @Test
    public void should_not_return_movie_when_reader_id_is_incorrect() {
        movieService.checkoutItem("M0001", "333-3333");
        String message = movieService.returnCheckedItem("M0001", "XXX-XXXX");
        assertEquals(message, "That is not a valid movie to return.");
    }

    @Test
    public void should_be_able_to_generate_movie_column_header() {
        assertEquals(movieService.generateItemColumnHeader(), Movie.getColumnHeader());
    }

    @Test
    public void should_be_able_to_generate_movie_column_content() {
        Movie movie = new Movie("id", "name", "2015", "director", 8);
        assertEquals(movieService.generateItemColumnContent(movie), movie.getColumnContent());
    }

    @Test
    public void should_be_able_to_list_checked_movies_and_its_readers() {
        List<String> checkedMovies = movieService.listCheckedItems();

        assertFalse(checkedMovies.isEmpty());
        assertTrue(checkedMovies.contains("Movie: The Avengers is checked by Waterstrong"));
    }
}
