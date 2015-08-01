package com.twu.biblioteca.domain;

import com.twu.biblioteca.enumeration.Action;

public class Menu {

    private String prompt;
    private Action action;

    public Menu(String prompt, Action action) {
        this.prompt = prompt;
        this.action = action;
    }

    public String getPrompt() {
        return prompt;
    }

    public Action getAction() {
        return action;
    }
}
