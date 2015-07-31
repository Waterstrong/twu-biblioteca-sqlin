package com.twu.biblioteca.service;

import java.util.List;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.repository.LibraryRepository;

public class BookService {

    public List<Book> listItems() {
        return LibraryRepository.listBooks();
    }
}
