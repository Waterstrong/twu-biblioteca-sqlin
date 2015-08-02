package com.twu.biblioteca.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovieTest {
    @Test
    public void should_be_able_to_get_movie_column_header_info() {
        String columnHeader = Movie.getColumnHeader();
        assertEquals(columnHeader, "Movie ID         Name         Year         Director         Rating\n" +
                                   "------------------------------------------------------------------");
    }

    @Test
    public void should_be_able_to_get_movie_column_content_info() {
        Movie movie = new Movie("M0001", "The Runner", "2015", "Austin Stark", 8.5);
        String columnContent = movie.getColumnContent();
        assertEquals(columnContent, "M0001    The Runner    2015    Austin Stark    8.5");
    }
}
