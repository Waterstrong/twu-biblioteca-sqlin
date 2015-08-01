package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuService {

    private Map<String, BookService> mainMenus = new HashMap<String, BookService>();

    public List<String> listMainMenus() {
        return new ArrayList<String>(mainMenus.keySet());
    }

    public void attachMainMenu(String menuTitle, BookService service) {
        mainMenus.put(menuTitle, service);
    }
}
