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
    public void setUp() throws Exception {
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

//    @Test
//    public void should_be_able_to_exit_application() throws Exception {
//        consoleServiceMock.setOption(4);
//        libraryService.run();
//        //verify(consoleServiceMock, times(1)).sayBye();
//    }

//    @Test
//    public void should_be_able_to_output_invalid_message_when_option_is_zero_or_out_of_scope() throws Exception {
//        consoleServiceMock.setOption(0, 8, 4);
//        libraryService.run();
////        verify(consoleServiceMock, times(2)).printMessage("Select a valid option!");
//    }
//
//    @Ignore
//    @Test
//    public void should_be_able_to_execute_list_books_action() throws Exception {
//        consoleServiceMock.setOption(1, 4);
//        libraryService.run();
////        verify(bookServiceMock, times(1)).listItems();
//    }
//
//    @Ignore
//    @Test
//    public void should_be_able_to_execute_checkout_item_action() throws Exception {
//        consoleServiceMock.setOption(2, 4);
//        libraryService.run();
////        verify(bookServiceMock, times(1)).checkoutItem("AAA", "AAA");
//    }
//
//    @Ignore
//    @Test
//    public void should_be_able_to_execute_return_checked_item_action() throws Exception {
//        consoleServiceMock.setOption(3, 4);
//        libraryService.run();
////        verify(bookServiceMock, times(1)).returnCheckedItem("AAA");
//    }



    class ConsoleServiceMock extends ConsoleService {
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
            System.out.print(prompt);
            return "AAA";
        }
    }

    class BookServiceMock extends BookService {
        public List<Book> listItems() {
            return new ArrayList<Book>();
        }

        public String checkoutItem(String bookId, String readerId) {
            return "checkout item executed";
        }

        public String returnCheckedItem(String bookId) {
            return "return checked item executed";
        }
    }
}