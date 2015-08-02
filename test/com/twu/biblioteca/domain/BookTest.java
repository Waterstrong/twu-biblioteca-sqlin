package com.twu.biblioteca.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("B0001", "title", "author", "2005", "press");
    }

    @Test
    public void should_be_able_to_get_book_column_info() {
        String columnHeader = Book.getColumnHeader();

        assertEquals(columnHeader, "Book ID         Title         Author     Published Year      Press\n" +
                "------------------------------------------------------------------");
    }

    @Test
    public void should_be_able_to_get_format_book_column_content() {
        String columnContent = book.getColumnContent();

        assertEquals(columnContent, "B0001    title    author    2005    press");
    }
}