package by.etc.somnum;

//Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
//консоль текст, заголовок текста.

import java.util.Arrays;

class Word {

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {

        if (word.matches("[A-z]{1,}")) {
            this.word = word;
        } else {
            this.word = "";
        }
    }

    public Word(String word) {
        this.setWord(word);
    }

    @Override
    public String toString() {
        return getWord();
    }
}

class Sentence {

    private Word[] words;

    public Sentence(Word[] words) {

        this.words = words;
    }

    @Override
    public String toString() {

        String someSentence = "";
        for (int i = 0; i < words.length; i++) {
            someSentence += (words[i] + " ");
        }
        return someSentence;
    }
}

class Text {

    private Sentence[] sentences;
    private Sentence header;

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Sentence getHeader() {
        return header;
    }

    public void setHeader(Sentence header) {
        this.header = header;
    }

    public Text(Sentence[] sentences) {

        this.sentences = sentences;
    }

    @Override
    public String toString() {

        String someSentence = "";
        someSentence += ("" + getHeader() + "\n");

        for (int i = 0; i < sentences.length; i++) {
            someSentence += (sentences[i] + ". ");
        }
        return someSentence;
    }

    public void printBody() {

        System.out.println("Текст: ");
        for (int i = 0; i < sentences.length; i++) {
            System.out.print(sentences[i].toString() + ". ");
        }
    }

    public void printHeader() {

        System.out.println("Заголовок: ");
        System.out.println(getHeader().toString());
        System.out.println();
    }

    public void appendSentence(Sentence text) {

        Sentence[] newSentences = new Sentence[getSentences().length + 1];
        for (int i = 0; i < getSentences().length; i++) {
            newSentences[i] = sentences[i];
        }
        newSentences[getSentences().length] = text;
        setSentences(newSentences);
    }
}

public class AggregationAndComposition_exe_1 {

    public static void main(String[] args) {

        Word[] someWords = new Word[2];
        someWords[0] = new Word("Hello");
        someWords[1] = new Word("world");

        Word[] someWordsTwo = new Word[2];
        someWordsTwo[0] = new Word("Love");
        someWordsTwo[1] = new Word("you");

        Sentence[] sentences = new Sentence[2];
        sentences[0] = new Sentence(someWords);
        sentences[1] = new Sentence(someWordsTwo);

        Text text = new Text(sentences);
        Word[] array = new Word[1];
        array[0] = new Word("Summer");
        Sentence headersentence = new Sentence(array);
        text.setHeader(headersentence);

        text.printHeader();
        text.printBody();

        Word[] newWord = new Word[1];
        newWord[0] = new Word("Food");

        System.out.println("\n\nМы добавили одно предложение и выводим на экран полный текст: ");
        text.appendSentence(new Sentence(newWord));
        text.printBody();
    }
}
