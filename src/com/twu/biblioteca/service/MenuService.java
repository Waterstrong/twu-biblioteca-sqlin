package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.enumeration.MainMenu;

public class MenuService {

    private Map<MainMenu, ItemService> mainMenus = new HashMap<MainMenu, ItemService>();

    public List<MainMenu> listMainMenus() {
        return new ArrayList<MainMenu>(mainMenus.keySet());
    }

    public void registerMainMenu(MainMenu menuTitle, ItemService service) {
        mainMenus.put(menuTitle, service);
    }
}
