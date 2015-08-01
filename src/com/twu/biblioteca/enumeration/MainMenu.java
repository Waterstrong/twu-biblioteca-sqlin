package com.twu.biblioteca.enumeration;

public enum MainMenu {
    LIST_BOOKS("List Books");

    private String title;

    MainMenu(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
