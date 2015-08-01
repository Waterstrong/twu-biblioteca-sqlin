package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Menu;

public class MenuService {

    private Map<Menu, ItemService> menus = new HashMap<Menu, ItemService>();

    public List<Menu> listMainMenus() {
        return new ArrayList<Menu>(menus.keySet());
    }

    public void registerMainMenu(Menu menu, ItemService service) {
        menus.put(menu, service);
    }

}
