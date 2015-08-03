package com.twu.biblioteca;

import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;
import com.twu.biblioteca.enumeration.Role;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.ItemService;
import com.twu.biblioteca.service.MenuService;
import com.twu.biblioteca.service.MovieService;

public class LibraryFactory {

    public static MenuService generateMenuServiceByRole(Role role) {
        MenuService menuService = new MenuService();
        ItemService bookService = new BookService();
        ItemService movieService = new MovieService();
        menuService.registerMainMenu(new Menu("List Books", Action.LIST_ITEMS), bookService);
        menuService.registerMainMenu(new Menu("List Movies", Action.LIST_ITEMS), movieService);
        switch (role) {
            case CUSTOMER:
                menuService.registerMainMenu(new Menu("Checkout Book", Action.CHECKOUT_ITEM), bookService);
                menuService.registerMainMenu(new Menu("Checkout Movie", Action.CHECKOUT_ITEM), movieService);
                menuService.registerMainMenu(new Menu("Return Book", Action.RETURN_ITEM), bookService);
                menuService.registerMainMenu(new Menu("Return Movie", Action.RETURN_ITEM), movieService);
                break;
            case LIBRARIAN:
                menuService.registerMainMenu(new Menu("Who Checked Books", Action.LIST_CHECKED), bookService);
                menuService.registerMainMenu(new Menu("Who Checked Movies", Action.LIST_CHECKED), movieService);
                break;
            default: break;
        }
        menuService.registerMainMenu(new Menu("My Profile", Action.DISPLAY_PROFILE), null);
        menuService.registerMainMenu(new Menu("Quit", Action.QUIT), null);
        return menuService;
    }
}
