package com.twu.biblioteca.service;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsoleServiceTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ConsoleService consoleService;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        consoleService = new ConsoleService();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_be_able_to_show_welcome_message() {
        consoleService.showWelcome();
        assertEquals(outContent.toString(), "===============Welcome to the Biblioteca!===============\n\n");
    }

    @Test
    public void should_be_able_to_print_specified_error_message() {
        String message = "This is an error message.";
        consoleService.printError(message);
        assertEquals(errContent.toString(), message+"\n\n");
    }

    @Test
    public void should_be_able_to_show_tips_for_choosing_option() throws Exception {
        consoleService.showChoosingOptionPrompt();
        assertEquals(outContent.toString(), "Please choose an option: ");
    }

}
