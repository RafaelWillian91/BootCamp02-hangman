package hangman.resource;

import hangman.core.Word;
import jdk.dynalink.beans.StaticClass;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.random.RandomGenerator;

public class Dictionary {
    public static final String PATH_WORD = "/hangman/resource/dictionary.txt";
    private List<String> listWord;
    private Random random = new Random();

    public Dictionary()throws Exception{
        //O arquivo .txt está junto com as classes então ele deve ser acessado pelo recurso de reflection
        URL url = getClass().getResource(PATH_WORD);
        listWord = Files.readAllLines(Path.of(url.toURI()));
        System.out.println(listWord);
    }

    public String nextWord(){
        return listWord.get(random.nextInt(0, listWord.size()));
    }

}
