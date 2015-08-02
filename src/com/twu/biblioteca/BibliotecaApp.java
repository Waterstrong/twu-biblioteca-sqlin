package com.twu.biblioteca;

import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;
import com.twu.biblioteca.service.AccountService;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.ConsoleService;
import com.twu.biblioteca.service.ItemService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MenuService;
import com.twu.biblioteca.service.MovieService;

public class BibliotecaApp {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        AccountService accountService = new AccountService();
        login(accountService, consoleService);

        MenuService menuService = new MenuService();
        registerMenu(menuService);

        LibraryService libraryService = new LibraryService(accountService.getLoginUser(), menuService, consoleService);

        libraryService.run();
    }

    private static void registerMenu(MenuService menuService) {
        ItemService bookService = new BookService();
        ItemService movieService = new MovieService();
        menuService.registerMainMenu(new Menu("List Books", Action.LIST_ITEMS), bookService);
        menuService.registerMainMenu(new Menu("Checkout Book", Action.CHECKOUT_ITEM), bookService);
        menuService.registerMainMenu(new Menu("Return Book", Action.RETURN_ITEM), bookService);
        menuService.registerMainMenu(new Menu("List Movies", Action.LIST_ITEMS), movieService);
        menuService.registerMainMenu(new Menu("Checkout Movie", Action.CHECKOUT_ITEM), movieService);
        menuService.registerMainMenu(new Menu("Return Movie", Action.RETURN_ITEM), movieService);
        menuService.registerMainMenu(new Menu("My Profile", Action.DISPLAY_PROFILE), null);
        menuService.registerMainMenu(new Menu("Quit", Action.QUIT), null);
    }

    private static void login(AccountService accountService, ConsoleService consoleService) {
        boolean isLogin = false;
        int tryTimes = 5;
        while (!isLogin) {
            String loginId = consoleService.inputWithPrompt("Please input login id: ");
            String password = consoleService.inputWithPrompt("Please input login password: ");
            isLogin = accountService.login(loginId, password);
            if(isLogin) {
                consoleService.printMessage("Login Successfully!");
            } else {
                consoleService.printError("Login Failed! Please check your id and password.");
                if(tryTimes <= 0) {
                    consoleService.printError("Try too many, application exit!");
                    System.exit(0);
                }
                consoleService.inputWithPrompt("");
            }
            --tryTimes;
        }
    }
}
