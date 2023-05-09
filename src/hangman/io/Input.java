package hangman.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Input {

    private static final Scanner SCANNER = new Scanner(System.in);
    private Input(){}

    //Faz a leitura do arquivo .txt e retorna uma list de Strings
    public static List<String> readLinesfromFile (String path){
        //O arquivo .txt está junto com as classes então ele deve ser acessado pelo recurso de reflection
        URL url = Input.class.getResource(path);

        if(url == null){
            throw new RuntimeException("File is found" + path);
        }

        try {
            return Files.readAllLines(Path.of(url.toURI()), UTF_8);
        }catch (IOException | URISyntaxException e){
            throw new RuntimeException("Error Loading dictionary" + e);
        }

    }

    //Método que recebe uma letra de tentativa.
    //Como não é para fechar o Scanner ele foi criado como atributo estático da classe sem fechamento no fim.
    public static String readFromKeyboard(String message){
        //Se a menssagem não é nula
        if (!Objects.isNull(message)){
            Output.writeToConsole(message + ": ", false);
        }
        return SCANNER.nextLine();
    }


}
