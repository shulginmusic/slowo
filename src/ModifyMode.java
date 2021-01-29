import java.util.Map;
import java.util.Scanner;

public class ModifyMode {
    //Mode to change a word
    Scanner scanner;
    WordBank wordBank;

    public ModifyMode(Scanner scanner, WordBank wordBank) {
        this.scanner = scanner;
        this.wordBank = wordBank;
    }

    public WordBank modifyWord() {
        System.out.print("Enter English word you'd like to modify: ");
        String wordToModify = scanner.next();
        //Fail first
        if (!wordBank.words.containsKey(wordToModify)) {
            System.out.println("No such word in Word Bank");
            return wordBank;
        }
        System.out.print("Enter an updated translation of the word: ");
        String wordUpdated = scanner.next();
        wordBank.words.replace(wordToModify, wordUpdated);
        System.out.println("New translation for " + wordToModify + " is " + wordBank.words.get(wordToModify));
        return wordBank;

    }
}
