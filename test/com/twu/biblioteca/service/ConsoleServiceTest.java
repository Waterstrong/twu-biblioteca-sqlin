package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Menu;
import com.twu.biblioteca.enumeration.Action;

public class ConsoleServiceTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ConsoleService consoleService;
    private ConsoleServiceMock consoleServiceMock;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        consoleService = new ConsoleService();
        consoleServiceMock = new ConsoleServiceMock();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_be_able_to_show_welcome_message() {
        consoleService.showWelcome();
        assertEquals(outContent.toString(), "\n===============Welcome to the Biblioteca!===============\n");
    }

    @Test
    public void should_be_able_to_show_bye_message() throws Exception {
        consoleService.sayBye();
        assertEquals(outContent.toString(), "\n===============Thank you for using the Biblioteca! Bye!===============\n\n");
    }

    @Test
    public void should_be_able_to_print_specified_error_message() {
        String message = "This is an error message.";
        consoleService.printError(message);
        assertEquals(errContent.toString(), message + "\n");
    }

    @Test
    public void should_be_able_to_print_specified_message() throws Exception {
        String message = "This is a message.";
        consoleService.printMessage(message);
        assertEquals(outContent.toString(), message + "\n");
    }

    @Test
    public void should_be_able_to_choose_an_option() throws IOException {
        consoleServiceMock.setInputBuffer("1");
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 1);
    }

    @Test
    public void should_not_get_an_valid_option_when_input_is_null() throws Exception {
        consoleServiceMock.setInputBuffer(null);
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 0);
    }

    @Test
    public void should_not_get_an_valid_option_when_input_is_not_integer() throws Exception {
        consoleServiceMock.setInputBuffer("buffer");
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 0);
    }

    @Test
    public void should_be_able_to_print_menu_prompt() {
        List<Menu> menus = new ArrayList<Menu>(Arrays.asList(
                new Menu("List Books", Action.LIST_ITEMS),
                new Menu("Checkout Book", Action.CHECKOUT_ITEM),
                new Menu("Quit", Action.QUIT)
        ));
        consoleService.printMenuPrompt(menus);
        assertEquals(outContent.toString(), "\n1.List Books      2.Checkout Book      3.Quit\n");
    }

    @Test
    public void should_be_able_to_input_nothing_with_prompt() throws Exception {
        String prompt = "please input: ";
        consoleService.getBufferedReader().close();
        String input = consoleService.inputWithPrompt(prompt);
        assertEquals(outContent.toString(), prompt);
        assertNull(input);
    }

    @Test
    public void should_be_able_to_print_book_list() throws Exception {
        List<Book> books = new ArrayList<Book>(Arrays.asList(
                new Book("123", "hello", "water", "2015", "press"),
                new Book("456", "haha", "lin", "2015", "bbc")
        ));
        consoleService.printBookList(books);
        String result = "Book ID         Title         Author     Published Year      Press\n" +
                "------------------------------------------------------------------\n" +
                "123    hello    water    2015    press\n" +
                "456    haha    lin    2015    bbc\n";
        assertEquals(outContent.toString(), result);
    }


    class ConsoleServiceMock extends ConsoleService {
        private String inputBuffer;
        public String inputWithPrompt(String prompt){
            return inputBuffer;
        }

        public void setInputBuffer(String inputBuffer) {
            this.inputBuffer = inputBuffer;
        }
    }
}
