package com.twu.biblioteca.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountServiceTest {
    private AccountService accountService;

    @Before
    public void setUp() {
        accountService = new AccountService();
    }

    @Test
    public void should_be_able_to_login() {
        boolean isLogin = accountService.login("111-1111", "123456");
        assertTrue(isLogin);
    }


}
