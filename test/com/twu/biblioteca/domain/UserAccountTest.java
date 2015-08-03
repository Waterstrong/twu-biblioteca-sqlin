package com.twu.biblioteca.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.enumeration.Role;

public class UserAccountTest {

    private UserAccount userAccount;

    @Before
    public void setUp() throws Exception {
        userAccount = new UserAccount("111-1111", "123456", "Waterstrong", "sqlin@thoughtworks.com", "15008180790", Role.CUSTOMER);
    }

    @Test
    public void should_be_able_to_get_user_information() {
        String userInfo = userAccount.getUserProfile();
        assertEquals(userInfo, "ID: 111-1111 | Role: CUSTOMER | Name: Waterstrong | Email: sqlin@thoughtworks.com | Phone: 15008180790");
    }

    @Test
    public void should_be_able_to_check_password() {
        boolean result = userAccount.checkPassword("123456");
        assertTrue(result);
    }

    @Test
    public void should_not_check_password_when_password_is_incorrect() {
        boolean result = userAccount.checkPassword("654321");
        assertFalse(result);
    }
}