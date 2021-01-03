import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Start {
    
    public static final Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    
    public static void main(String[] args) {
        
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Перечень слов: " + Arrays.toString(words));
        String message = "Угадайте, какое из перечисленных слов загадано.";
        String secret = getRandomWord(words);
        String userWord;
        do {
            userWord = getWordFromScanner(message, words);
            if (userWord.equals(secret)) {
                System.out.println("Вы угадали! Игра окончена!");
                break;
            } else {
                System.out.println("Слово не угадали, но посмотри какие буквы совпали: ");
                comparisonCharAndPrint(userWord, secret);
            }
        } while (true);
        
        System.out.println("Конец игры.");
    }
    
    private static void comparisonCharAndPrint(String userWord, String secret) {
        char[] result = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        char[] arrayUserWord = userWord.toCharArray();
        char[] arraySecret = secret.toCharArray();
        
        for (int i = 0; i < arraySecret.length; i++) {
            
            for (char c : arrayUserWord) {
                if (c == arraySecret[i]) {
                    result[i] = c;
                }
            }
        }
        System.out.println("Совпали буквы: " + String.valueOf(result));
    }
    
    private static String getRandomWord(String[] words) {
        int position = getRandomNumber(words.length);
        return words[position];
    }
    
    public static String getWordFromScanner(String message, String[] words) {
        String x;
        
        do {
            System.out.println(message);
            x = sc.next();
            
        } while (!check(x, words));
        return x;
    }
    
    public static boolean check(String word, String[] words) {
        for (String string : words) {
            if (word != null && word.equals(string)) {
                return true;
            }
        }
        return false;
    }
    
    private static int getRandomNumber(int max) {
        return r.nextInt(max);
    }
    
}
