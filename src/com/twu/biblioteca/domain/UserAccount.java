package com.twu.biblioteca.domain;

import com.twu.biblioteca.enumeration.Role;

public class UserAccount {
    private final String userId;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;
    private final Role role;

    public UserAccount(String userId, String password, String name, String email, String phone, Role role) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    public String getUserProfile() {
        String split = " | ";
        return "ID: " + getUserId() + split + "Role: " + getRole().name() + split +
                "Name: " + getName() + split + "Email: " + getEmail() + split +
                "Phone: " + getPhone();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
