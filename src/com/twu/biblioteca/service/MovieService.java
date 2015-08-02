package com.twu.biblioteca.service;

import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.repository.LibraryRepository;

public class MovieService extends ItemService<Movie> {

    private final String SUCCESSFUL_CHECKOUT_MOVIE_MESSAGE = "Thank you! Enjoy the movie!";
    private final String UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE = "That movie is not available.";
    private final String SUCCESSFUL_RETURN_MOVIE_MESSAGE = "Thank you for returning the movie.";
    private final String UNSUCCESSFUL_RETURN_MOVIE_MESSAGE = "That is not a valid movie to return.";

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
        LibraryRepository.returnCheckedMovie(itemId);
        return SUCCESSFUL_RETURN_MOVIE_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulCheckoutMessage() {
        return UNSUCCESSFUL_CHECKOUT_MOVIE_MESSAGE;
    }

    @Override
    protected String getUnsuccessfulReturnMessage() {
        return UNSUCCESSFUL_RETURN_MOVIE_MESSAGE;
    }
}
