package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Book;

public class BookServiceTest {

    private ItemService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService();
    }

    @Test
    public void should_be_able_to_get_book_list() {
        List<Book> bookList = bookService.listItems();

        assertFalse(bookList.isEmpty());
        Book book = bookList.get(0);
        assertEquals(book.getId(), "B0001");
        assertEquals(book.getTitle(), "Head First Java");
        assertEquals(book.getAuthor(), "Kathy Sierra & Bates");
        assertEquals(book.getPublishedYear(), "2005");
        assertEquals(book.getPress(), "O'Reilly Media, Inc");
    }

    @Test
    public void should_be_able_to_checkout_book() {
        String message = bookService.checkoutItem("B0002", "R0001");
        assertEquals(message, "Thank you! Enjoy the book");
    }

    @Test
    public void should_not_checkout_book_when_book_is_already_checked_out() {
        bookService.checkoutItem("B0001", "R0001");
        String message = bookService.checkoutItem("B0001", "R0002");
        assertEquals(message, "That book is not available.");
    }

    @Test
    public void should_not_checkout_book_when_book_not_exists() {
        String message = bookService.checkoutItem("B000X", "R0001");
        assertEquals(message, "That book is not available.");
    }

    @Test
    public void should_be_able_to_return_book() {
        bookService.checkoutItem("B0001", "R0001");
        String message = bookService.returnCheckedItem("B0001");
        assertEquals(message, "Thank you for returning the book.");
    }

    @Test
    public void should_not_be_able_to_return_book() {
        String message = bookService.returnCheckedItem("B000X");
        assertEquals(message, "That is not a valid book to return.");
    }
}
