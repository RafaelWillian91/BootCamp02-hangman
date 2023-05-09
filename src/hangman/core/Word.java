package hangman.core;

public class Word {
    private static final char HIDDEN_CHAR = '_';
    private final char[] letters;
    private final char[] hiddenLetters;
    public Word(String word){
        letters = word.toUpperCase().toCharArray();
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

    //Chegagem para verificar se existe um "_". O indexOf retorna -1 caso não encontre o caracter passado.
    public boolean revelead(){

        return toString().indexOf(HIDDEN_CHAR) == -1;

    }

    public String show(){
        return String.valueOf(letters);
    }

    @Override
    public String toString() {
        //Feito um espacamento com StringBuilder
        StringBuilder sb = new StringBuilder();
        for(char st : hiddenLetters){
            sb.append(st).append(" ");
        }
        return sb.toString().trim();
    }
}
