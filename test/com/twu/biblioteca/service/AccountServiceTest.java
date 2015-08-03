package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
    public void should_be_able_to_login_from_console() {
        UserAccount loginUser = accountService.loginByConsole(new ConsoleServiceMock(), 1);
        assertEquals(loginUser.getUserId(), "111-1111");
        assertEquals(loginUser.getName(), "Waterstrong");
        assertEquals(loginUser.getEmail(), "sqlin@thoughtworks.com");
        assertEquals(loginUser.getPhone(), "15008180790");
        assertEquals(loginUser.getRole(), Role.CUSTOMER);
    }

    @Test
    public void should_not_login_from_console_when_attempts_used_out() {
        UserAccount loginUser = accountService.loginByConsole(new ConsoleServiceMockAgain(), 5);
        assertNull(loginUser);
    }

    class ConsoleServiceMock extends ConsoleService {
        public String inputWithPrompt(String prompt) {
            if(prompt == "Please input login id: ") {
                return "111-1111";
            }
            if (prompt == "Please input login password: ") {
                return "123456";
            }
            return prompt;
        }

        public void printMessage(String message) {
        }

        public void printError(String error) {
        }
    }

    class ConsoleServiceMockAgain extends ConsoleServiceMock {
        public String inputWithPrompt(String prompt) {
            return prompt;
        }
    }
}
