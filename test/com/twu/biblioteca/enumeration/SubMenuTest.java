package com.twu.biblioteca.enumeration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubMenuTest {
    @Test
    public void should_be_able_to_get_correct_prompt() {
        assertEquals(SubMenu.CHECKOUT_ITEM.getPrompt(), "Checkout from ");
        assertEquals(SubMenu.RETURN_ITEM.getPrompt(), "Return to ");
    }
}