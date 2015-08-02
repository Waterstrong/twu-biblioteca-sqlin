package com.twu.biblioteca.service;

import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.repository.LibraryRepository;

public class MovieService extends ItemService<Movie> {

    @Override
    protected Map<String, Movie> getItemsFromRepository() {
        return LibraryRepository.listMovies();
    }

    @Override
    protected Map<String, String> getCheckedItemsFromRepository() {
        return LibraryRepository.getCheckedMovies();
    }

    @Override
    protected void sortItemList(List<Movie> itemList) {

    }

    @Override
    protected String saveCheckoutBookToRepository(String itemId, String readerId) {
        return null;
    }

    @Override
    protected String returnCheckedItemToRepository(String itemId) {
        return null;
    }

    @Override
    protected String getUnsuccessfulCheckoutMessage() {
        return null;
    }

    @Override
    protected String getUnsuccessfulReturnMessage() {
        return null;
    }
}
