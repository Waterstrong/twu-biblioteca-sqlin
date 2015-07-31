package com.twu.biblioteca.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.twu.biblioteca.domain.Book;

public class LibraryRepository {

    private static List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("0001", "Head First Java", "Kathy Sierra & Bates", "2005", "O'Reilly Media, Inc")
    ));

    public static List<Book> listBooks() {
        return books;
    }
}
