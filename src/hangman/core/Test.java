package hangman.core;

import hangman.resource.Dictionary;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        Dictionary dictionary = Dictionary.instance();
        System.out.println(dictionary.nextWord());
    }
}
