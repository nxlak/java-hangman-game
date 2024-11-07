package Game;
import java.util.Scanner;
import java.util.ArrayList;

import Draw.Draw;

public class Game {
    public static void game(String hidden_word, int max_mistakes_count) {
        String[] chars_in_word = new String[hidden_word.length()];
        for (int i = 0; i < hidden_word.length(); ++i) {
            chars_in_word[i] = "_";
        }

        //System.out.println(hidden_word);

        int made_mistakes = 0;
        Scanner in = new Scanner(System.in);

        while (true) {
            Draw.draw(chars_in_word, made_mistakes);
            System.out.println("Enter char:");

            String input = in.nextLine();
            if (input.length() != 1) {
                System.out.println("Please enter a single character!");
                continue;
            }

            input = input.toUpperCase();
            char guessedChar = input.charAt(0);
            int index_in_word = hidden_word.indexOf(guessedChar);
            if (index_in_word == -1) {
                ++made_mistakes;
                if (made_mistakes == max_mistakes_count) {
                    Draw.draw(chars_in_word, made_mistakes);
                    System.out.println("You made last mistake! The word was: " + hidden_word);
                    break;
                }
                System.out.println("Mistake! Be more attentive!\nYou can still do " + (max_mistakes_count-made_mistakes) + " mistakes!");
            } else {
                while (index_in_word != -1) {
                    chars_in_word[index_in_word] = String.valueOf(guessedChar);
                    index_in_word = hidden_word.indexOf(guessedChar, index_in_word + 1);
                }
            }

            if (String.join("", chars_in_word).equals(hidden_word)) {
                System.out.println("Congratulations! You've guessed the word: " + hidden_word);
                break;
            }
        }
        in.close();
    }
}
