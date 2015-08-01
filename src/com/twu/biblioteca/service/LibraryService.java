package com.twu.biblioteca.service;

import java.util.List;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Menu;

public class LibraryService {
    private final String INVALID_OPTION_MESSAGE = "Select a valid option!";
    private MenuService menuService;
    private ConsoleService consoleService;

    public LibraryService(MenuService menuService, ConsoleService consoleService) {
        this.menuService = menuService;
        this.consoleService = consoleService;
    }

    public void run() {
        while (true) {
            List<Menu> menus = menuService.listMainMenus();
            consoleService.printMenuPrompt(menus);
            consoleService.chooseOption();
            int option = consoleService.chooseOption();
            if(option == 0 || option > menus.size()) {
                consoleService.printMessage(INVALID_OPTION_MESSAGE);
                continue;
            }
            Menu menu = menus.get(option-1);
            ItemService itemService = menuService.getItemService(menu);
            switch (menu.getAction()) {
                case LIST_ITEMS:
                    List<Book> books = itemService.listItems();
                    ConsoleService.printBookList(books);
                    break;
                case CHECKOUT_ITEM:
                    String bookId = consoleService.inputWithPrompt("Please input book id which you want to checkout: ");
                    String readerId = consoleService.inputWithPrompt("Please input the read id: ");
                    String result = itemService.checkoutItem(bookId, readerId);
                    consoleService.printMessage(result);
                    break;
                case RETURN_ITEM:
                    break;
                case QUIT:
                    System.exit(0);
                    break;
            }
        }
    }
}
