package com.twu.biblioteca.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.repository.LibraryRepository;

public class BookService extends ItemService<Book> {

    private final String SUCCESSFUL_CHECKOUT_BOOK_MESSAGE = "Thank you! Enjoy the book";
    private final String UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE = "That book is not available.";
    private final String SUCCESSFUL_RETURN_BOOK_MESSAGE = "Thank you for returning the book.";
    private final String UNSUCCESSFUL_RETURN_BOOK_MESSAGE = "That is not a valid book to return.";

    @Override
    protected Map<String, String> getCheckedItemsFromRepository() {
        return LibraryRepository.getCheckedBooks();
    }

    @Override
    protected Map<String, Book> getItemsFromRepository() {
        return LibraryRepository.listBooks();
    }

    @Override
    protected void sortItemList(List<Book> itemList) {
        Collections.sort(itemList, new Comparator<Book>() {
            @Override
            public int compare(Book item1, Book item2) {
                return item1.getId().compareTo(item2.getId());
            }
        });
    }

    @Override
    protected String saveCheckoutItemToRepository(String itemId, String readerId) {
        LibraryRepository.saveCheckoutBook(itemId, readerId);
        return SUCCESSFUL_CHECKOUT_BOOK_MESSAGE;
    }

    @Override
    protected String returnCheckedItemToRepository(String itemId) {
        LibraryRepository.returnCheckedBook(itemId);
        return SUCCESSFUL_RETURN_BOOK_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulCheckoutMessage() {
        return UNSUCCESSFUL_CHECKOUT_BOOK_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulReturnMessage() {
        return UNSUCCESSFUL_RETURN_BOOK_MESSAGE;
    }
}
