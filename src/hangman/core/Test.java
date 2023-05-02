package hangman.core;

import hangman.resource.Dictionary;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception{

        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.nextWord());
    }
}
