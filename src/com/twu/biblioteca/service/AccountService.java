package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.repository.LibraryRepository;

public class AccountService {

    private UserAccount loginUser;

    public boolean login(String loginId, String password) {
        if (loginId == null || loginId.isEmpty() ||
                password == null || password.isEmpty()) {
            return false;
        }
        loginUser = LibraryRepository.findUserAccount(loginId, password);
        return loginUser != null;
    }

    public UserAccount loginByConsole(ConsoleService consoleService, int attempts) {
        boolean isLogin = false;
        while (!isLogin) {
            String loginId = consoleService.inputWithPrompt("Please input login id: ");
            String password = consoleService.inputWithPrompt("Please input login password: ");
//            String password = new String(System.console().readPassword());
            isLogin = login(loginId, password);
            if(!isLogin) {
                consoleService.printError("Login Failed! Please check your id and password.");
                if(attempts <= 0) {
                    consoleService.printError("=======Try too many! Login Aborted!=======");
                    return null;
                }
                consoleService.inputWithPrompt("");
                --attempts;
            }
        }
        consoleService.printMessage("Login Successfully! Welcome to the Biblioteca!");
        consoleService.printMessage(loginUser.getUserProfile());
        return loginUser;
    }
}
