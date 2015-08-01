package com.twu.biblioteca.domain;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String publishedYear;
    private final String press;

    public Book(String id, String title, String author, String publishedYear, String press) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.press = press;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public String getPress() {
        return press;
    }

    public String getColumnHeader() {
        return "Book ID         Title         Author     Published Year      Press\n" +
                "------------------------------------------------------------------";
    }

    public String getColumnContent() {
        return getId() + "    " + getTitle() + "    " + getAuthor() + "    " + getPublishedYear() + "    " + getPress();
    }
}
