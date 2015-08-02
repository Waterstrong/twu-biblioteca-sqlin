package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.repository.LibraryRepository;

public class AccountService {

    private UserAccount loginUser;

    public boolean login(String loginId, String password) {
        if (loginId == null || loginId.isEmpty() ||
                password == null || password.isEmpty()) {
            return false;
        }
        loginUser = LibraryRepository.findUserAccount(loginId, password);
        return loginUser != null;
    }

    public UserAccount getLoginUser() {
        return loginUser;
    }
}
