package com.twu.biblioteca.service;

import java.util.List;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Menu;

public class LibraryService {
    private final String INVALID_OPTION_MESSAGE = "Select a valid option!";
    private final String NOT_SUPPORT_ACTION_ERROR = "Not Support This Action!";
    private final String SYSTEM_PAUSE_MESSAGE = "\n************Press enter to continue!***********";
    private MenuService menuService;
    private ConsoleService consoleService;

    public LibraryService(MenuService menuService, ConsoleService consoleService) {
        this.menuService = menuService;
        this.consoleService = consoleService;
    }

    public void run() {
        boolean isRunning = true;
        consoleService.showWelcome();
        while (isRunning) {
            List<Menu> menus = menuService.listMainMenus();
            consoleService.printMenuPrompt(menus);
            int option = consoleService.chooseOption();
            if (option == 0 || option > menus.size()) {
                consoleService.printMessage(INVALID_OPTION_MESSAGE);
                continue;
            }
            isRunning = handleAction(menus, option);
            systemPause();
        }
    }

    private void systemPause() {
        consoleService.inputWithPrompt(SYSTEM_PAUSE_MESSAGE);
    }

    private boolean handleAction(List<Menu> menus, int option) {
        Menu menu = menus.get(option - 1);
        ItemService itemService = menuService.getItemService(menu);
        String prompt = menu.getPrompt().toLowerCase();
        switch (menu.getAction()) {
            case LIST_ITEMS:
                listItems(itemService);
                break;
            case CHECKOUT_ITEM:
                checkoutItem(itemService, prompt);
                break;
            case RETURN_ITEM:
                returnItem(itemService, prompt);
                break;
            case QUIT:
                consoleService.sayBye();
                return false;
            default:
                consoleService.printError(NOT_SUPPORT_ACTION_ERROR);
                break;
        }
        return true;
    }

    private void listItems(ItemService itemService) {
        List<Book> books = itemService.listItems();
        consoleService.printBookList(books);
    }

    private void returnItem(ItemService itemService, String prompt) {
        String itemId = consoleService.inputWithPrompt("Please input the " + prompt + " id: ");
        String message = itemService.returnCheckedItem(itemId);
        consoleService.printMessage(message);
    }

    private void checkoutItem(ItemService itemService, String prompt) {
        String bookId = consoleService.inputWithPrompt("Please input the " + prompt + " id: ");
        String readerId = consoleService.inputWithPrompt("Please input the read id: ");
        String result = itemService.checkoutItem(bookId, readerId);
        consoleService.printMessage(result);
    }
}
