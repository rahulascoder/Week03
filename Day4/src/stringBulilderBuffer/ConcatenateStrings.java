package stringBulilderBuffer;

public class ConcatenateStrings {

    //creating concatenate method to concatinate string
    public static String concatenate(String[] words) {
        // initilizing a StringBuffer object for concatenation
        StringBuffer sb = new StringBuffer();

        // Iterating through each string in the array and append it to StringBuffer
        for (String word : words) {
            sb.append(word);
        }

        // Converting  StringBuffer to a string
        return sb.toString();
    }

    public static void main(String[] args) {
        // input
        String[] words = {"Hello", " ", " World", " ,I", " am", " here", " ."};

        // Concatenating the strings
        String result = concatenate(words);
        System.out.println("Concatenated String: " + result);
    }
}
