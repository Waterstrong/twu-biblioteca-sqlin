package com.twu.biblioteca.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookTest {
    @Test
    public void should_be_able_to_get_book_column_info() throws Exception {
        Book book = new Book(null, null, null, null, null);

        String columnHeader = book.getColumnHeader();

        assertEquals(columnHeader, "Book ID         Title         Author     Published Year      Press\n" +
                "------------------------------------------------------------------");
        System.out.println(columnHeader);
    }

    @Test
    public void should_be_able_to_get_format_book_column_content() throws Exception {
        Book book = new Book("B0001", "title", "author", "2005", "press");

        String columnContent = book.getColumnContent();

        assertEquals(columnContent, "B0001    title    author    2005    press");
        System.out.println(columnContent);
    }
}