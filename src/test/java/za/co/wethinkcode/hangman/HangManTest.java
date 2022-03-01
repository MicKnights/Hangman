package za.co.wethinkcode.hangman;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HangManTest {
//    @Test
//    public void notDivisibleBy3or5() {
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        String result = fizzBuzz.checkNumber(13);
//        assertEquals("13", result);
//    }
//
//    @Test
//    public void divisibleBy3() {
//        // Insert your test code here
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        String result = fizzBuzz.checkNumber(6);
//        assertEquals("Fizz", result);
//    }
//
//    @Test
//    public void divisibleBy5() {
//        // Insert your test code here
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        String result = fizzBuzz.checkNumber(10);
//        assertEquals("Buzz", result);
//    }
//
//    @Test void divisibleBy3And5() {
//        // Insert your test code here
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        String result = fizzBuzz.checkNumber(15);
//        assertEquals("FizzBuzz", result);
//    }
//
//    @Test
//    public void generateUpTo15() {
//        za.co.wethinkcode.fizzbuzz.FizzBuzz fizzBuzz = new FizzBuzz();
//        String result = fizzBuzz.countTo(15);
//        assertEquals("[1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]", result);
//    }

    @Test
    public void testUserInput(){
        String data = "a";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        HangMan hangman = new HangMan();
        String userInput = hangman.userInput();

        assertEquals(data, userInput);
    }


    @Test
    public void testDrawFigure(){
        String data = "/----\n |   0\n |  /|\\\n |   |\n |  / \\\n _______";

        HangMan hangman = new HangMan();
        String userInput = hangman.drawFigure(0);

        assertEquals(data, userInput);
    }


    @Test
    public void testReplaceCorrect(){
        String data = "test";

        HangMan hangman = new HangMan();
        String userInput = hangman.replaceCorrect("test", "t_st", "e");

        assertEquals(data, userInput);
    }


    @Test
    public void testSelectWord(){}


    @Test
    public void testFillWord(){
        String data = "test";

        HangMan hangman = new HangMan();
        String userInput = hangman.fillWord(data);

        assertNotEquals(data, userInput);
    }


    @Test
    public void testRunHangman(){}

}
