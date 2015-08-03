package com.twu.biblioteca.repository;

import java.util.HashMap;
import java.util.Map;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.enumeration.Role;

public class LibraryRepository {

    private static final HashMap<String, UserAccount> userAccounts = new HashMap<String, UserAccount>();
    private static final Map<String, Book> books = new HashMap<String, Book>();
    private static final Map<String, Movie> movies = new HashMap<String, Movie>();

    private static Map<String, String> checkedBooks = new HashMap<String, String>();
    private static Map<String, String> checkedMovies = new HashMap<String, String>();

    static {
        books.put("B0001", new Book("B0001", "Head First Java", "Kathy Sierra & Bates", "2005", "O'Reilly Media, Inc"));
        books.put("B0002", new Book("B0002", "Test Driven Development", "Kent Beck", "2002", "Addison-Wesley Professional"));
        books.put("B0003", new Book("B0003", "Refactoring", "Martin Fowler & Kent Beck et al", "1999", "Addison-Wesley Professional"));
        books.put("B0004", new Book("B0004", "Think in Java", "Bruce Eckel", "2007", "CM Press"));

        movies.put("M0001", new Movie("M0001", "The Runner", "2015", "Austin Stark", 8.5));
        movies.put("M0002", new Movie("M0002", "The Avengers", "2012", "Joss Whedon", 9));
        movies.put("M0003", new Movie("M0003", "Furious 7", "2015", "James Wan", 9.1));
        movies.put("M0004", new Movie("M0004", "Escape Plan", "2013", "Jan Mikael", 9));

        userAccounts.put("111-1111", new UserAccount("111-1111", "123456", "Waterstrong", "sqlin@thoughtworks.com", "15008180790", Role.CUSTOMER));
        userAccounts.put("222-2222", new UserAccount("222-2222", "123456", "Wrongkey", "kdhu@thoughtworks.com", "1800000000", Role.CUSTOMER));

        saveCheckoutBook("B0002", "222-2222");
        saveCheckoutMovie("M0002", "111-1111");
    }

    public static Map<String, Book> listBooks() {
        return books;
    }

    public static void saveCheckoutBook(String bookId, String readerId) {
        checkedBooks.put(bookId, readerId);
    }

    public static Map<String, String> getCheckedBooks() {
        return checkedBooks;
    }

    public static void returnCheckedBook(String bookId) {
        checkedBooks.remove(bookId);
    }

    public static Map<String, Movie> listMovies() {
        return movies;
    }

    public static Map<String, String> getCheckedMovies() {
        return checkedMovies;
    }

    public static void saveCheckoutMovie(String movieId, String readerId) {
        checkedMovies.put(movieId, readerId);
    }

    public static void returnCheckedMovie(String movieId) {
        checkedMovies.remove(movieId);
    }

    public static UserAccount findUserAccount(String userId, String password) {
        UserAccount userAccount = userAccounts.get(userId);
        return (userAccount == null || !userAccount.checkPassword(password)) ? null : userAccount;
    }
}
