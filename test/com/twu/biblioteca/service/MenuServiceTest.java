package com.twu.biblioteca.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.enumeration.MainMenu;
import com.twu.biblioteca.enumeration.SubMenu;

public class MenuServiceTest {

    private MenuService menuService;

    @Before
    public void setUp() {
        menuService = new MenuService();
        menuService.registerMainMenu(MainMenu.LIST_BOOKS, new BookService());
    }

    @Test
    public void should_be_able_to_get_main_menu() {
        List<MainMenu> menus = menuService.listMainMenus();

        assertFalse(menus.isEmpty());
        assertTrue(menus.contains(MainMenu.LIST_BOOKS));
    }

    @Test
    public void should_be_able_to_get_sub_menu() {
        List<SubMenu> subMenus = menuService.listSubMenu(MainMenu.LIST_BOOKS);
        assertFalse(subMenus.isEmpty());
        assertTrue(subMenus.contains(SubMenu.CHECKOUT_ITEM));
        assertTrue(subMenus.contains(SubMenu.RETURN_ITEM));
    }
}
