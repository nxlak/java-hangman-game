package Words;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Words {
    public static String getWord(String key) {
        Map<String, String[]> words = new HashMap<>();

        // Категория: Животные
        String[] animals = {"CAT", "DOG", "ELEPHANT", "TIGER", "GIRAFFE"};
        words.put("Animals", animals);

        // Категория: Фрукты
        String[] fruits = {"APPLE", "BANANA", "ORANGE", "PEAR", "KIWI"};
        words.put("Fruits", fruits);

        // Категория: Страны
        String[] countries = {"RUSSIA", "USA", "CHINA", "INDIA", "BRAZILIA"};
        words.put("Countries", countries);

        String[] word_vec = words.get(key);
        Random random = new Random();
        
        return word_vec[random.nextInt(word_vec.length - 1)];
    }
}
