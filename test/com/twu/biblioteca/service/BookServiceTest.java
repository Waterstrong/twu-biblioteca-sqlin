package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Book;

public class BookServiceTest {

    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService();
    }

    @Test
    public void should_be_able_to_get_book_list() {
        BookService bookService = new BookService();

        List<Book> bookList = bookService.listItems();

        assertFalse(bookList.isEmpty());
        Book book = bookList.get(1);
        assertEquals(book.getId(), "B0001");
        assertEquals(book.getTitle(), "Head First Java");
        assertEquals(book.getAuthor(), "Kathy Sierra & Bates");
        assertEquals(book.getPublishedYear(), "2005");
        assertEquals(book.getPress(), "O'Reilly Media, Inc");
    }

    @Test
    public void should_be_able_to_checkout_book() {

        String message = bookService.checkoutItem("B0001", "R0001");
        assertEquals(message, "Thank you! Enjoy the book");
    }
}
