package com.twu.biblioteca.domain;

public class Movie {
    private final String id;
    private final String name;
    private final String year;
    private final String director;
    private final double rating;

    public Movie(String id, String name, String year, String director, double rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    public static String getColumnHeader() {
        return "Movie ID         Name         Year         Director         Rating\n" +
                "------------------------------------------------------------------";
    }

    public String getColumnContent() {
        return getId() + "    " + getName() + "    " + getYear() + "    " + getDirector() + "    " + getRating();
    }
}
