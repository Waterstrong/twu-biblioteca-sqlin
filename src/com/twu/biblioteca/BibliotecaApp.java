package com.twu.biblioteca;

import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.ConsoleService;
import com.twu.biblioteca.service.ItemService;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.service.MenuService;
import com.twu.biblioteca.service.MovieService;

public class BibliotecaApp {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        ItemService bookService = new BookService();
        ItemService movieService = new MovieService();
        menuService.registerMainMenu(new Menu("List Books", Action.LIST_ITEMS), bookService);
        menuService.registerMainMenu(new Menu("Checkout Book", Action.CHECKOUT_ITEM), bookService);
        menuService.registerMainMenu(new Menu("Return Book", Action.RETURN_ITEM), bookService);
        menuService.registerMainMenu(new Menu("List Movies", Action.LIST_ITEMS), movieService);
        menuService.registerMainMenu(new Menu("Checkout Movie", Action.CHECKOUT_ITEM), movieService);
        menuService.registerMainMenu(new Menu("Return Book", Action.RETURN_ITEM), movieService);
        menuService.registerMainMenu(new Menu("Quit", Action.QUIT), null);
        ConsoleService consoleService = new ConsoleService();
        LibraryService libraryService = new LibraryService(menuService, consoleService);

        libraryService.run();
    }
}
