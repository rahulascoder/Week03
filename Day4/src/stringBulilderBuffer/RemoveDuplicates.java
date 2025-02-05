package stringBulilderBuffer;

import java.util.HashSet;

public class RemoveDuplicates {
    //creating method to  remove duplicates
    public static String removeDuplicates(String input) {
        // Initialize StringBuilder to store unique characters
        StringBuilder sb = new StringBuilder();

        // HashSet to keep track of already seen characters
        HashSet<Character> seen = new HashSet<>();

        // Iterating over each character in the input string using for each loop
        for (char ch : input.toCharArray()) {

            // If the character is not already present in the HashSet
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }

        // Converting StringBuilder to string and returning
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);

        // Printing   result
        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }
}
