package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import com.twu.biblioteca.enumeration.MainMenu;

public class MenuServiceTest {
    @Test
    public void should_be_able_to_get_main_menu() {
        MenuService menuService = new MenuService();
        menuService.registerMainMenu(MainMenu.LIST_BOOKS, new BookService());

        List<MainMenu> menus = menuService.listMainMenus();

        assertFalse(menus.isEmpty());
        assertEquals(menus.get(0).getTitle(), "List Books");
    }
}
