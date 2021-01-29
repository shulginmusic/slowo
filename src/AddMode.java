import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;

public class AddMode {
    Scanner scanner;
    WordBank wordBank;
    public AddMode(Scanner scanner, WordBank wordBank) {
        this.scanner = scanner;
        this.wordBank = wordBank;
    }
    public void addWords() throws IOException {

        boolean quitMode = false;
        String newWordEnglish;
        String newWordForeign;
        while (!quitMode) {
            System.out.println("Ok, let's add some words to study later!");
            System.out.print("Enter a word in English: ");
            newWordEnglish = scanner.next();
            System.out.print("Enter a word in the foreign language: ");
            newWordForeign = scanner.next();
            System.out.print("Would you like to add another? (y/q to quit) ");
            String quit = scanner.next();
            if (quit.equals("q")) {
                quitMode = true;
            }
            wordBank.words.put(newWordEnglish, newWordForeign);
            scanner.nextLine();
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("wordbank.txt"));
        out.writeObject(wordBank);
    }
    //TODO add boolean flag that checks if words were added, if not do not write the object back to be more efficient
}
