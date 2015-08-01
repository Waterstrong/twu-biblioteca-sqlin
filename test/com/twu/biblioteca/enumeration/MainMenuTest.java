package com.twu.biblioteca.enumeration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainMenuTest {
    @Test
    public void should_be_able_to_get_correct_prompt() {
        assertEquals(MainMenu.LIST_BOOKS.getPrompt(), "List Books");
    }
}