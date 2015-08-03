package com.twu.biblioteca;

import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.service.AccountService;
import com.twu.biblioteca.service.ConsoleService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MenuService;

public class BibliotecaApp {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        consoleService.printMessage("Tips: Predefined User credentials: \n" +
                "{[\n  {id: 111-1111, pwd: 123456, role: CUSTOMER },\n" +
                "  {id: 222-2222, pwd: 123456, role: LIBRARIAN}\n]}");
        consoleService.showWelcome();

        AccountService accountService = new AccountService();
        UserAccount loginUser = accountService.loginByConsole(consoleService, 5);

        while(loginUser != null) {
            MenuService menuService = LibraryFactory.generateMenuServiceByRole(loginUser.getRole());
            LibraryService libraryService = new LibraryService(loginUser, menuService, consoleService);
            libraryService.run();
            consoleService.showWelcome();
            loginUser = accountService.loginByConsole(consoleService, 5);
        }

    }
}
