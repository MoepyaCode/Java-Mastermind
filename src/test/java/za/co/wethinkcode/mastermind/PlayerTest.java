package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testExit() {
        Player player = new Player(new ByteArrayInputStream("exit\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("exit", guess);
    }


    @Test
    void testQuit() {
        Player player = new Player(new ByteArrayInputStream("quit\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("quit", guess);
    }


    @Test
    void testGuessCorrect() {
        Player player = new Player(new ByteArrayInputStream("1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }

    @Test
    void testGuessTooShort() {
        Player player = new Player(new ByteArrayInputStream("123\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessTooLong() {
        Player player = new Player(new ByteArrayInputStream("12345\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotDigits() {
        Player player = new Player(new ByteArrayInputStream("12ab\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessEmpty() {
        Player player = new Player(new ByteArrayInputStream("\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotInRageLow() {
        Player player = new Player(new ByteArrayInputStream("0123\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotInRageHigh() {
        Player player = new Player(new ByteArrayInputStream("1239\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
        assertEquals(
                "Input 4 digit code:\nPlease enter exactly 4 digits (each from 1 to 8).\nInput 4 digit code:",
                outputStreamCaptor.toString().trim());

    }

}