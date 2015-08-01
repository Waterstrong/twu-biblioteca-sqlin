package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.enumeration.MainMenu;
import com.twu.biblioteca.enumeration.SubMenu;

public class MenuService {

    private Map<MainMenu, ItemService> mainMenus = new HashMap<MainMenu, ItemService>();
    private Map<SubMenu, MainMenu> subMenus = new HashMap<SubMenu, MainMenu>();

    public List<MainMenu> listMainMenus() {
        return new ArrayList<MainMenu>(mainMenus.keySet());
    }

    public void registerMainMenu(MainMenu mainMenu, ItemService service) {
        mainMenus.put(mainMenu, service);
        registerSubMenu(SubMenu.CHECKOUT_ITEM, mainMenu);
        registerSubMenu(SubMenu.RETURN_ITEM, mainMenu);
    }

    private void registerSubMenu(SubMenu subMenu, MainMenu mainMenu) {
        subMenus.put(subMenu, mainMenu);
    }

    public List<SubMenu> listSubMenu(MainMenu menu) {
        List<SubMenu> subMenuList = new ArrayList<SubMenu>();
        for (SubMenu subMenu : subMenus.keySet()) {
            if(subMenus.get(subMenu) == menu) {
                subMenuList.add(subMenu);
            }
        }
        return subMenuList;
    }
}
