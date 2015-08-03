package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;
import com.twu.biblioteca.enumeration.Role;
import com.twu.biblioteca.service.MenuService;

public class LibraryFactoryTest {
    @Test
    public void should_be_able_generate_menu_service_by_role_of_customer() {
        MenuService menuService = LibraryFactory.generateMenuServiceByRole(Role.CUSTOMER);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() > 7);
        assertEquals(menus.get(2).getAction(), Action.CHECKOUT_ITEM);
    }

    @Test
    public void should_be_able_generate_menu_service_by_role_of_librarian() {
        MenuService menuService = LibraryFactory.generateMenuServiceByRole(Role.LIBRARIAN);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() > 5);
        assertEquals(menus.get(2).getAction(), Action.LIST_CHECKED);
    }

    @Test
    public void should_be_able_to_generate_menu_service_by_role_of_undefine() {
        MenuService menuService = LibraryFactory.generateMenuServiceByRole(Role.UNDEFINE);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() < 5);
    }
}
