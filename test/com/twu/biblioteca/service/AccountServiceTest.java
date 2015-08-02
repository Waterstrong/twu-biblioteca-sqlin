package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.UserAccount;
import com.twu.biblioteca.enumeration.Role;

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

    @Test
    public void should_not_login_when_password_is_incorrect() {
        boolean isLogin = accountService.login("111-1111", "654321");
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_not_exists() {
        boolean isLogin = accountService.login("xxx-xxxx", "123456");
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_or_password_is_null() {
        boolean isLogin = accountService.login("111-1111", null);
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_is_null() {
        boolean isLogin = accountService.login(null, "123456");
        assertFalse(isLogin);
    }

    @Test
    public void should_be_able_get_login_user_account_after_login() {
        accountService.login("111-1111", "123456");
        UserAccount userAccount = accountService.getLoginUser();
        assertEquals(userAccount.getUserId(), "111-1111");
        assertEquals(userAccount.getName(), "Waterstrong");
        assertEquals(userAccount.getEmail(), "sqlin@thoughtworks.com");
        assertEquals(userAccount.getPhone(), "15008180790");
        assertEquals(userAccount.getRole(), Role.CUSTOMER);
    }
}
