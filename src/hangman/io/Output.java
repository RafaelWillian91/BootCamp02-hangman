package hangman.io;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class Output {

    //PrintWriter é um Writer é System.out é uma Stream, então preciso transformar uma Stream em um Writer.
    //Posso usar a classe de conversão OutputStreamWriter
    private static final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);

   // private static final PrintWriter printWriter = new PrintWriter(System.out,true, StandardCharsets.UTF_8);
    private Output(){}

    public static void writeToConsole(){
        writeToConsole(null, true);
    }

    public static void writeToConsole(Object obj) {
        writeToConsole(obj, true);
    }

    //Como não é para fechar o Scanner ele foi criado como atributo estático da classe
    public static void writeToConsole(Object obj, boolean newLine){
        if(Objects.isNull(obj)){
            printWriter.println();
        } else if (newLine) {
            printWriter.println(obj);

        }else
        printWriter.format("%s ", obj);
    }


}
