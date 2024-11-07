import java.util.Scanner;
import java.util.Random;
import Game.Game;
import Words.Words;

public class App {
    public static void gameMenu(Scanner in) {
        System.out.println("Game started!\nChoose the difficulty of the game:");
        System.out.println("1 - Easy\n2 - Medium\n3 - Hard\n4 - Random");
        int level = in.nextInt();
        
        System.out.println("Now choose category of words:");
        System.out.println("1 - Animals\n2 - Fruits\n3 - Countries\n4 - Random");

        int category = in.nextInt();

        if (level == 4) {
            Random random = new Random();
            level = random.nextInt(3) + 1;    
        }
        if (category == 4) {
            Random random = new Random();
            category = random.nextInt(3) + 1;  
        }

        String category_str = null;
        switch (category) {
            case 1:
                category_str = "Animals";   
                break;
            case 2:
                category_str = "Fruits";
                break;
            case 3:
                category_str = "Countries";
                break;
            default:
                break;
        }

        int mistakes_count = 0;
        switch (level) {
            case 1:
                mistakes_count = 8;
                break;
            case 2:
                mistakes_count = 6;
                break;
            case 3:
                mistakes_count = 4;
                break;
            default:
                break;
        }

        String hidden_word = Words.getWord(category_str);
        
        System.out.println("The word is hidden! You have the right to " + mistakes_count + " mistakes.");

        Game.game(hidden_word, mistakes_count);
    } 

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int answ = 0; 

        while (true) { 
            System.out.println("Hi! Game \"Hangman\" started!\nChoose:\n1 - Play\n2 - Exit");
            answ = in.nextInt();

            switch (answ) {
                case 1:
                    System.out.println("Starting the game..."); 
                    gameMenu(in); 
                    return; 
                case 2:
                    System.out.println("Goodbye!");
                    return; 
                default:
                    System.out.println("Not correct answer! Try again!");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    } 
}