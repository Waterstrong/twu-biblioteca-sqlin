package com.twu.biblioteca.service;

import java.util.List;

import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.domain.UserAccount;

public class LibraryService {
    private final String INVALID_OPTION_MESSAGE = "Select a valid option!";
    private final String NOT_SUPPORT_ACTION_ERROR = "Not Support This Action!";
    private final String SYSTEM_PAUSE_MESSAGE = "\n************Press enter to continue!***********";
    private final MenuService menuService;
    private final ConsoleService consoleService;
    private final UserAccount loginUser;

    public LibraryService(UserAccount loginUser, MenuService menuService, ConsoleService consoleService) {
        this.loginUser = loginUser;
        this.menuService = menuService;
        this.consoleService = consoleService;
    }

    public void run() {
        boolean isRunning = true;
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
            case LIST_CHECKED:
                listCheckedItems(itemService);
                break;
            case DISPLAY_PROFILE:
                consoleService.printMessage(loginUser.getUserProfile());
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

    private void listCheckedItems(ItemService itemService) {
        List<String> checkedItemsInfo = itemService.listCheckedItems();
        for (String info : checkedItemsInfo) {
            consoleService.printMessage(info);
        }
    }

    private void listItems(ItemService itemService) {
        List items = itemService.listItems();
        consoleService.printMessage(itemService.generateItemColumnHeader());
        for (int i = 0; i < items.size(); ++i) {
            consoleService.printMessage(itemService.generateItemColumnContent(items.get(i)));
        }
    }

    private void returnItem(ItemService itemService, String prompt) {
        String itemId = consoleService.inputWithPrompt("Please input the " + prompt + " id: ");
        String message = itemService.returnCheckedItem(itemId, loginUser.getUserId());
        consoleService.printMessage(message);
    }

    private void checkoutItem(ItemService itemService, String prompt) {
        String bookId = consoleService.inputWithPrompt("Please input the " + prompt + " id: ");
        String result = itemService.checkoutItem(bookId, loginUser.getUserId());
        consoleService.printMessage(result);
    }
}
