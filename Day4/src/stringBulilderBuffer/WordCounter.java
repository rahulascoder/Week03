package stringBulilderBuffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Hp\\Desktop\\Java Training\\Week03\\Day4\\src\\stringBulilderBuffer/sample.txt";
        String targetWord = "testing";

        int wordCount = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                // Spliting line into words based on spaces
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Case-insensitive comparison
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}
