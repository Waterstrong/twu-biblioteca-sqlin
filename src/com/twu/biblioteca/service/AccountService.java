package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.repository.LibraryRepository;

public class AccountService {

    private UserAccount loginUserAccount;

    public boolean login(String userId, String password) {
        loginUserAccount = LibraryRepository.findUserAccount(userId, password);
        return loginUserAccount != null;
    }
}
