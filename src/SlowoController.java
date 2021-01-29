import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class SlowoController {
    WordBank wordBank;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Load in previous wordBank object
        File wordBankFile = new File("wordbank.txt");
        WordBank wordBank = loadWordBank(wordBankFile);
        //Greeting + ask what mode the user would like
        boolean programRunning = true;
        System.out.println("\n----------------------\nWelcome to Slowo, the best app" +
                " for tracking and studying new foreign language vocabulary!");
        while (programRunning) {
            System.out.println("\n----Main Menu----\n" +
                    "Choose one of the options below: \n-add\n-study\n-modify\n-view\n-delete\n-quit");
            System.out.print("Enter: ");
            //Create scanner object
            Scanner scanner = new Scanner(System.in, "UTF-8");
            scanner.useDelimiter("\n"); //This is to take in Strings with spaces, e.g. "die frau"
            String modeSelector = scanner.next();
            //Add new words mode
            if (modeSelector.equals("add")) {
                displayWords(wordBank);
                AddMode addMode = new AddMode(scanner, wordBank);
                addMode.addWords();
            }
            //Study mode
            if (modeSelector.equals("study")) {
                StudyMode studyMode = new StudyMode(scanner, wordBank);
                studyMode.studyWords();
            }
            //Modify mode
            if (modeSelector.equals("modify")) {
                displayWords(wordBank);
                ModifyMode modifyMode = new ModifyMode(scanner, wordBank);
                wordBank = modifyMode.modifyWord();
            }
            //View mode
            if (modeSelector.equals("view")) {
                displayWords(wordBank);
            }
            //Quit app if nothing is selected
            if (modeSelector.equals("quit")) {
                programRunning = false;
            }
            //DELETE a word or all words in Worbank
            if (modeSelector.equals("delete")) {
                DeleteMode deleteMode = new DeleteMode(scanner, wordBank);
                System.out.print("Would you like to delete a word or all words? (all/one) ");
                String deleteReply = scanner.next();
                if (deleteReply.equals("one")) {
                    wordBank = deleteMode.deleteAWord();
                } else if (deleteReply.equals("all")) {
                    wordBank = deleteMode.deleteALL();
                }
            }
        }
        saveWordBank(wordBank);
        quit();
    }

    public static void saveWordBank(WordBank wordBank) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("wordbank.txt"));
        out.writeObject(wordBank);
    }

    public static WordBank loadWordBank(File wordBankFile) throws IOException,
            ClassNotFoundException {
        WordBank wordBank;
        if (wordBankFile.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("wordbank.txt"));
            wordBank = (WordBank) in.readObject();
            return wordBank;
        } else {
            return new WordBank(); //create new one if file is empty
        }
    }

    public static void displayWords(WordBank wordBank) {
        if (wordBank.words.size() == 0) {
            System.out.println("No words currently in the Word Bank!");
        } else {
            System.out.println("\nHere are the words currently in the Word Bank:");
            for (Map.Entry<String, String> word : wordBank.words.entrySet()) {
                System.out.println(word.getKey() + ": " + word.getValue());
            }
        }
    }

    public static void quit() {
        System.exit(0);
    }
}

//TODO while loop for the entire thing
//Exception for user inputs


