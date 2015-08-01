package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

public class MenuServiceTest {
    @Test
    public void should_be_able_to_get_main_menu() {
        MenuService menuService = new MenuService();
        menuService.attachMainMenu("List Books", new BookService());

        List<String> menus = menuService.listMainMenus();

        assertFalse(menus.isEmpty());
        assertEquals(menus.get(0), "List Books");
    }
}
