package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.domain.Menu;

public class MenuService {

    private Map<Menu, ItemService> menus = new LinkedHashMap<Menu, ItemService>();

    public List<Menu> listMainMenus() {
        return new ArrayList<Menu>(menus.keySet());
    }

    public void registerMainMenu(Menu menu, ItemService service) {
        menus.put(menu, service);
    }

    public ItemService getItemService(Menu menu) {
        return menus.get(menu);
    }
}
