package com.twu.biblioteca.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.enumeration.Action;

public class MenuTest {

    @Test
    public void should_be_able_to_get_prompt_and_action() {
        Menu menu = new Menu("List Books", Action.LIST_ITEMS);

        assertEquals(menu.getPrompt(), "List Books");
        assertEquals(menu.getAction(), Action.LIST_ITEMS);
    }

}