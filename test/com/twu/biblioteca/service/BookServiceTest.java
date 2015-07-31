package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import com.twu.biblioteca.domain.Book;

public class BookServiceTest {
    @Test
    public void should_be_able_to_get_book_list() throws Exception {
        BookService bookService = new BookService();

        List<Book> books = bookService.listItems();

        assertFalse(books.isEmpty());
        Book book = books.get(0);
        assertEquals(book.getId(), "0001");
        assertEquals(book.getTitle(), "Head First Java");
        assertEquals(book.getAuthor(), "Kathy Sierra & Bates");
        assertEquals(book.getPublishedYear(), "2005");
        assertEquals(book.getPress(), "O'Reilly Media, Inc");
    }
}
