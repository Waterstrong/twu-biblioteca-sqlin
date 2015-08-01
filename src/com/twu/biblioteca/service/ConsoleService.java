package com.twu.biblioteca.service;

public class ConsoleService {
    public void showWelcome() {
        System.out.println("===============Welcome to the Biblioteca!===============\n");
    }

    public void printError(String error) {
        System.err.println(error+"\n");
    }

    public void showChoosingOptionPrompt() {
        System.out.print("Please choose an option: ");
    }
}
