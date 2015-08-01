package com.twu.biblioteca.enumeration;

public enum SubMenu {
    CHECKOUT_ITEM("Checkout from "), RETURN_ITEM("Return to ");

    private String prompt;

    SubMenu(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
