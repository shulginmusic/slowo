import java.util.*;

public class StudyMode {
    Scanner scanner;
    WordBank wordBank;
    public StudyMode(Scanner scanner, WordBank wordBank) {
        this.scanner = scanner;
        this.wordBank = wordBank;
    }

    public void studyWords() {
        if (wordBank.words.size() == 0) {
            System.out.println("No words in Word Bank");
            return;
        }

//            getRandomWord(wordBank);
        //TODO Event hough hashmaps don't mantain the order, it would be nice to shuffle through every use of this method, since it maintains the order for the program when it runs at least
        //TODO Need to add how many words a user wants
        String userAnswer = "";
        int correct = 0;
        //Loop over all the entries in the wordbank.words hashmap
        for (Map.Entry<String, String> word : wordBank.words.entrySet()) {
            //Randomly decide whether to give a native or foreign word
            Random random = new Random();
            int randomInt = random.nextInt(2); //this will only give 0 or 1
            //If 0, give native word and ask to translate
            if (randomInt == 0) {
                System.out.println("Translate this word: " + word.getKey());
                userAnswer = scanner.next();
                if (userAnswer.equals(word.getValue())) {
                    System.out.println("Correct!");
                    correct++;
                } else {
                    System.out.println("Wrong! The right answer is " + word.getValue());
                }
            } else {
                System.out.println("Translate this word back to English: " + word.getValue());
                userAnswer = scanner.next();
                if (userAnswer.equals(word.getKey())) {
                    System.out.println("Correct!");
                    correct++;
                } else {
                    System.out.println("Wrong! The right answer is " + word.getKey());
                }
            }
        }
        System.out.println("You got " + correct + " words out of " + wordBank.words.size());
        double correctDouble = correct;
        double wordBankSizeDouble = wordBank.words.size();
        double correctPercentage = (correctDouble / wordBankSizeDouble) * 100;
        System.out.println("Grade: " + correctPercentage + "%");
        if (correctPercentage == 100.0) {
            System.out.println("Perfect, you know these words!");
        } else if (correctPercentage > 80.0) {
            System.out.println("Very good, just need a little more practice");
        } else {
            System.out.println("You need to study these words more, please try again!");
        }
    }


    public static void quit() {
        System.exit(0);
    }

//    public static void getRandomWord(WordBank wordBank) {
//        Random randomKey = new Random();
//        System.out.println(wordBank.words.keySet());
//    }
}
