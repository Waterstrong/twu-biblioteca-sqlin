package com.twu.biblioteca.service;

import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.repository.LibraryRepository;

public class MovieService extends ItemService<Movie> {

    private final String SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE = "Thank you! Enjoy the movie!";

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
    protected String saveCheckoutItemToRepository(String itemId, String readerId) {
        LibraryRepository.saveCheckoutMovie(itemId, readerId);
        return SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE;
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
