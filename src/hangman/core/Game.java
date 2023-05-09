package hangman.core;

import hangman.io.Input;
import hangman.resource.Dictionary;

import java.util.HashSet;
import java.util.Set;

import static hangman.io.Output.writeToConsole;

public class Game {

    private static final int MAX_CHANGES = 7;

    private int channgesLeft = MAX_CHANGES;

    //Collection Set for identifying the letter already typed
    private final Set<Character> letterUsed = new HashSet<>();
    public void start(){

        Dictionary letters = Dictionary.instance();
        Word letterWord = letters.nextWord();
        printWord(letterWord);

        while (!letterWord.revelead() && channgesLeft > 0) {
            char letter = readLetter();

                if(letterWord.reveal(letter)){
                    onHit();
                }else {
                    onMiss();
                }
            letterUsed.add(letter);
            printWord(letterWord);
        }

         onEnd(letterWord);

    }

    private void printWord(Word word){
        writeToConsole();
        writeToConsole(word);
        writeToConsole();
    }

    private char readLetter(){
        //Definido dentro de um while(true) para contar apenas jogadas validas. Quando for inválida ele fica no loop.
        while (true) {
            try {
                return validChar(Input.readFromKeyboard("Letter: "));
            } catch (InvalidLetterException e) {
                writeToConsole("Error: " + e.getMessage());
            }
        }
    }
    private char validChar(String text) throws InvalidLetterException{
       String textTrim = text.trim().toUpperCase();

       if(textTrim.length() == 0){
           throw new InvalidLetterException("Empty letter is not allowed");

       } else if (textTrim.length() > 1) {
           throw new InvalidLetterException("Provide only one letter");
       }

        char letter = textTrim.charAt(0);

       if(!Character.isLetter(letter)){
           throw new InvalidLetterException("Only letters are allowed");
       }

       if(letterUsed.contains(letter)){
           throw new InvalidLetterException("You alredy tried this one");
       }

        return letter;
    }


    public void onHit(){
        writeToConsole("You found it!");
    }


    public void onMiss(){
        channgesLeft--;
        writeToConsole("You missed..." + channgesLeft + " change(s) left");
    }

    private void onEnd(Word letterWordfinished){
        if (letterWordfinished.revelead()) {
            writeToConsole("\n ******  You Win!!! ******");
        } else {
            writeToConsole("******  You Missed! ******");
            writeToConsole("\nThe word was: " + letterWordfinished.show());
            writeToConsole("\n ******  Better luck next time... !!! ******");
        }

    }


}
