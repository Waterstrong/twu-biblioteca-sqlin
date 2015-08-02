package com.twu.biblioteca.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import com.twu.biblioteca.enumeration.Role;

public class UserAccountTest {
    @Test
    public void should_be_able_to_get_user_information() throws Exception {
        UserAccount userAccount = new UserAccount("111-1111", "123456", "Waterstrong", "sqlin@thoughtworks.com", "15008180790", Role.CUSTOMER);
        String userInfo = userAccount.getUserProfile();
        assertEquals(userInfo, "ID: 111-1111 | Role: CUSTOMER | Name: Waterstrong | Email: sqlin@thoughtworks.com | Phone: 15008180790");
    }
}