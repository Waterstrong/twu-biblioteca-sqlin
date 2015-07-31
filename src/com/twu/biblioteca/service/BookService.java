package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.repository.LibraryRepository;

public class BookService {

    public List<Book> listItems() {
        Map<String, Book> books = LibraryRepository.listBooks();
        Map<String, String> checkoutBooks = LibraryRepository.getCheckoutBooks();
        List<Book> bookList = new ArrayList<Book>();
        for(String bookId : books.keySet()) {
            if(!checkoutBooks.containsKey(bookId)) {
                bookList.add(books.get(bookId));
            }
        }
        return bookList;
    }

    public String checkoutItem(String bookId, String readerId) {
        String message = "Thank you! Enjoy the book";
        if (isExistBook(bookId) && !isCheckedOut(bookId)) {
            LibraryRepository.saveCheckoutBook(readerId, bookId);
        } else {
            message = "That book is not available.";
        }
        return message;
    }

    private boolean isExistBook(String bookId) {
        return LibraryRepository.listBooks().containsKey(bookId);
    }

    private boolean isCheckedOut(String bookId) {
        return LibraryRepository.getCheckoutBooks().containsKey(bookId);
    }
}
