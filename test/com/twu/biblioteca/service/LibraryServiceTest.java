package com.twu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;

public class LibraryServiceTest {

    private ConsoleServiceMock consoleServiceMock;
    private BookServiceMock bookServiceMock;
    private MenuService menuService;
    private LibraryService libraryService;

    @Before
    public void setUp() {
        consoleServiceMock = new ConsoleServiceMock();

        bookServiceMock = new BookServiceMock();
        menuService = new MenuService();
        menuService.registerMainMenu(new Menu("List Books", Action.LIST_ITEMS), bookServiceMock);
        menuService.registerMainMenu(new Menu("Checkout Book", Action.CHECKOUT_ITEM), bookServiceMock);
        menuService.registerMainMenu(new Menu("Return Book", Action.RETURN_ITEM), bookServiceMock);
        menuService.registerMainMenu(new Menu("Quit", Action.QUIT), null);

        libraryService = new LibraryService(menuService, consoleServiceMock);
    }

    // TODO : waiting for mock dependency

    @Test
    public void should_be_able_to_exit_application() {
        consoleServiceMock.setOption(4);
        libraryService.run();
        //verify(consoleServiceMock, times(1)).sayBye();
    }

    @Test
    public void should_be_able_to_output_invalid_message_when_option_is_zero_or_out_of_scope() {
        consoleServiceMock.setOption(0, 8, 4);
        libraryService.run();
//        verify(consoleServiceMock, times(2)).printMessage("Select a valid option!");
    }

    @Test
    public void should_be_able_to_execute_list_books_action() {
        consoleServiceMock.setOption(1, 4);
        libraryService.run();
//        verify(bookServiceMock, times(1)).listItems();
    }

    @Test
    public void should_be_able_to_execute_checkout_item_action() {
        consoleServiceMock.setOption(2, 4);
        libraryService.run();
//        verify(bookServiceMock, times(1)).checkoutItem("AAA", "AAA");
    }

    @Test
    public void should_be_able_to_execute_return_checked_item_action() {
        consoleServiceMock.setOption(3, 4);
        libraryService.run();
//        verify(bookServiceMock, times(1)).returnCheckedItem("AAA");
    }

    @Test
    public void should_not_match_any_actions() {
        menuService.registerMainMenu(new Menu("Unkown", Action.UNKNOW), null);
        consoleServiceMock.setOption(5, 4);
        libraryService.run();
//        verify(consoleServiceMock, times(1)).printError("Not Support This Action!");
    }

    private class ConsoleServiceMock extends ConsoleService {
        private int[] options;
        private int index;

        public ConsoleServiceMock() {
            index = 0;
            options = new int[]{0};
        }

        public void setOption(int... options) {
            index = 0;
            this.options = options;
        }

        public int chooseOption() {
            printMessage("Please choose an option: " + options[index]);
            return options[index++];
        }

        public String inputWithPrompt(String prompt) {
            return "AAA";
        }

        public void showWelcome() {
        }

        public void sayBye() {
        }

        public void printMenuPrompt(List<Menu> menus) {
        }

        public void printBookList(List<Book> books) {
        }

        public void printMessage(String message) {
        }

        public void printError(String error) {
        }

    }

    private class BookServiceMock extends BookService {
        public List<Book> listItems() {
            return new ArrayList<Book>();
        }

        public String checkoutItem(String itemId, String readerId) {
            return "checkout item executed";
        }

        public String returnCheckedItem(String itemId) {
            return "return checked item executed";
        }
    }
}