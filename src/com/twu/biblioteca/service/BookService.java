package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.repository.LibraryRepository;

public class BookService {

    private final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    private final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";

    public List<Book> listItems() {
        Map<String, Book> books = LibraryRepository.listBooks();
        Map<String, String> checkoutBooks = LibraryRepository.getCheckoutBooks();
        List<Book> bookList = new ArrayList<Book>();
        for(String bookId : books.keySet()) {
            if(!checkoutBooks.containsKey(bookId)) {
                bookList.add(books.get(bookId));
            }
        }
        sortBookList(bookList);
        return bookList;
    }

    private void sortBookList(List<Book> bookList) {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getId().compareTo(book2.getId());
            }
        });
    }

    public String checkoutItem(String bookId, String readerId) {
        String message = SUCCESSFUL_CHECKOUT_MESSAGE;
        if (isExistBook(bookId) && !isCheckedOut(bookId)) {
            LibraryRepository.saveCheckoutBook(bookId, readerId);
        } else {
            message = UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }
        return message;
    }

    private boolean isExistBook(String bookId) {
        return LibraryRepository.listBooks().containsKey(bookId);
    }

    private boolean isCheckedOut(String bookId) {
        return LibraryRepository.getCheckoutBooks().containsKey(bookId);
    }

    public String returnBook(String bookId) {
        String message = "Thank you for returning the book.";
        if(LibraryRepository.getCheckoutBooks().containsKey(bookId)) {
            LibraryRepository.removeCheckoutBook(bookId);
        } else {
            message = "That is not a valid book to return.";
        }
        return message;
    }
}
