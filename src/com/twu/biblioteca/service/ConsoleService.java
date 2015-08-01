package com.twu.biblioteca.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.sun.tools.javac.util.Convert;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Menu;

public class ConsoleService {

    private final BufferedReader bufferedReader;

    public ConsoleService() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showWelcome() {
        System.out.println("===============Welcome to the Biblioteca!===============\n");
    }

    public void printError(String error) {
        System.err.println(error + "\n");
    }

    public int chooseOption() {
        String input = inputWithPrompt("Please choose an option: ");
        if(input != null) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
        }
        return 0;
    }

    public void printMenuPrompt(List<Menu> menus) {
        System.out.println();
        int size = menus.size();
        for (int index = 0; index < size; ++index) {
            System.out.print((index+1) + "." + menus.get(index).getPrompt());
            if (index == size - 1) {
                System.out.println();
            } else {
                System.out.print("      ");
            }
        }
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public String inputWithPrompt(String prompt) {
        System.out.print(prompt);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printMessage(String message) {
        System.out.println(message + "\n");
    }

    public static void printBookList(List<Book> books) {
        System.out.println(Book.getColumnHeader());
        for (Book book : books) {
            System.out.println(book.getColumnContent());
        }
    }
}
