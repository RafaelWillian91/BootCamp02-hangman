package hangman.resource;

import hangman.core.Word;
import hangman.io.Input;

import java.util.List;
import java.util.Random;

public class Dictionary {
    public static final String PATH_WORD = "/hangman/resource/dictionary.txt";

    private static final Dictionary INSTANCE = new Dictionary();
    private List<String> listWord;
    private Random random = new Random();

    //Popula uma lista a partir de um método static da classe de IO (Input)
    private Dictionary(){
        listWord = Input.readLinesfromFile(PATH_WORD);
    }

    public Word nextWord(){
        return new Word(listWord.get(random.nextInt(0, listWord.size())));
    }

    //Foi aplicado o desig pattern singleton para não haver outros Dictionary.
    public static Dictionary instance(){
        return INSTANCE;
    }

}
