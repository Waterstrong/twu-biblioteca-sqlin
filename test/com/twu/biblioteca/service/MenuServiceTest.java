package com.twu.biblioteca.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;

public class MenuServiceTest {

    private MenuService menuService;
    private Menu listBooksMenu;
    private Menu quitMenu;

    @Before
    public void setUp() {
        menuService = new MenuService();
        listBooksMenu = new Menu("List Books", Action.LIST_ITEMS);
        quitMenu = new Menu("Quit", Action.QUIT);

        menuService.registerMainMenu(listBooksMenu, new BookService());
        menuService.registerMainMenu(quitMenu, null);
    }

    @Test
    public void should_be_able_to_get_main_menu() {
        List<Menu> menus = menuService.listMainMenus();

        assertFalse(menus.isEmpty());
        assertTrue(menus.contains(listBooksMenu));
        assertTrue(menus.contains(quitMenu));
    }

}
