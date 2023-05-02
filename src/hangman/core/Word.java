package hangman.core;

public class Word {
    private static final char HIDDEN_CHAR = '_';
    private final char[] letters;
    private final char[] hiddenLetters;
    public Word(String word){
        letters = word.toCharArray();
        hiddenLetters = String.valueOf(HIDDEN_CHAR).repeat(word.length()).toCharArray();
    }

    public boolean reveal(char letterProvied){
        boolean replaced = false;

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == letterProvied){
                hiddenLetters[i] = letterProvied;
                replaced = true;
            }
        }
        return replaced;
    }

    @Override
    public String toString() {
        return String.valueOf(hiddenLetters);
    }
}
