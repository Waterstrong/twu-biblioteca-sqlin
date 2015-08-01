package com.twu.biblioteca.service;

import java.util.List;

import com.twu.biblioteca.domain.Book;

public interface ItemService {
    List<Book> listItems();

    String checkoutItem(String bookId, String readerId);

    String returnCheckedItem(String bookId);
}
