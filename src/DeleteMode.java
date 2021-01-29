import java.util.Map;
import java.util.Scanner;

public class DeleteMode {
    Scanner scanner;
    WordBank wordBank;

    public DeleteMode(Scanner scanner, WordBank wordBank) {
        this.scanner = scanner;
        this.wordBank = wordBank;
    }

    public WordBank deleteALL() {
        if (wordBank.words.size() == 0) {
            System.out.println("No words to delete");
            return wordBank;
        }
        displayWords(wordBank);
        System.out.print("Are you sure you want to delete all of them? (y/n) ");
        String deleteAllDecision = scanner.next();
        //Fail first
        if (deleteAllDecision.equals("n")) {
            return wordBank;
        }
        wordBank.words.clear();
        return wordBank;
    }

    public WordBank deleteAWord() {
        if (wordBank.words.size() == 0) {
            System.out.println("No words to delete");
            return wordBank;
        }
        displayWords(wordBank);
        System.out.print("Which word (English) would you like to delete? ");
        String wordToDelete = scanner.next();
        wordBank.words.remove(wordToDelete);
        return wordBank;
    }

    public static void displayWords(WordBank wordBank) {
        System.out.println("\nHere are the words currently in the Word Bank:");
        for (Map.Entry<String, String> word : wordBank.words.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }
}
