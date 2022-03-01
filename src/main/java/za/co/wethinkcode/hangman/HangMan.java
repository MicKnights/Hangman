package za.co.wethinkcode.hangman;

import java.util.Scanner;
import java.util.ArrayList;

public class HangMan {
    public String userInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Guess the missing letter: ");
        String userInput = input.nextLine();

        return userInput;
    }


    public String  drawFigure(int figure){

        String[] figures = {

                "/----\n |   0\n |  /|\\\n |   |\n |  / \\\n _______",

                "/----\n |   0\n |  /|\\\n |   |\n |\n _______",

                "/----\n |   0\n |   |\n |   |\n |\n _______",

                "/---- \n|   0 \n| \n| \n|\n _______",

                "/---- \n| \n| \n| \n|\n _______"
        };

        System.out.println(figures[figure]);
        return figures[figure];

    }


    public String  replaceCorrect(String origin, String filed, String input){
        int index = origin.indexOf(input);
        char[] wordList = filed.toCharArray();
        wordList[index] = origin.charAt(index);

        String newWord = "";
        int length;
        length = wordList.length;
        for (int i = 0; i < length; i++){
            newWord += wordList[i];
        }
        return  newWord;

    }


    public String selectWord(String fileName){
        // read from a text file using try catch.
        // randomly loop through the text file and select a word.
        // string
        String selectedWord = "test";

        return selectedWord;
    }


    public String fillWord(String word){
        String filledWord = "te__";

        return  filledWord;
    }


    public void output(int count){
        System.out.println("Wrong! Number of guesses left: " + count);
    }


    public void runHangman(){
        String word = selectWord("file");
        String gameWord = fillWord(word);
        int gameTry = 5;
        boolean isEqual = word.equals(gameWord);
        boolean isMissingChar = false;

        while (!isEqual){
            try {
                System.out.println("Guess the word: " + gameWord);
                String input = userInput();
                isMissingChar = word.contains(input);

                if (input.equals("exit") || input.equals("quit")){
                    System.out.println("Bye!");
                    break;

                }else if ( gameTry == 1){
                    System.out.println("Wrong! Number of guesses left: " + gameTry);
                    drawFigure(gameTry-1);
                    System.out.println("Sorry, you are out of guesses. The word was: " + word);
                    break;

                }else {
                    if (isMissingChar){
                        gameWord = replaceCorrect(word, gameWord, input);

                    }else{
                        gameTry -= 1;
                        System.out.println("Wrong! Number of guesses left: " + gameTry);
                        drawFigure(gameTry);

                    }
                }

                isEqual = word.equals(gameWord);
//                System.out.println(isEqual);

                if (isEqual){
                    System.out.println("Congratulations! The word was: " + word);
                    break;

                }
                continue;

            }catch (Exception e){
                System.out.println("Error! Incorrect input.");

            }
        }
    }


    public static void main(String[] args){
        HangMan run = new HangMan();
        run.runHangman();
    }
}