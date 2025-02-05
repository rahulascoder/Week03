package searching;

public class SearchWordInSentences {

    // Method to find the first sentence containing the specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through each sentence using for each loop
        for (String sentence : sentences) {
            // Checking if the sentence contains the word
            if (sentence.contains(word)) {
                // Returning first occurrence
                return sentence;
            }
        }
        // If not match
        return "Not Found";
    }

    public static void main(String[] args) {
        // Array of sentences
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a popular programming language.",
                "Data structures and algorithms are important.",
                "Practice makes perfect."
        };

        // Word we wants to search
        String word1 = "Java";
        String word2 = "Python";

        //  Results
        System.out.println("Sentence containing '" + word1 + "': " + findSentenceWithWord(sentences, word1));
        System.out.println("Sentence containing '" + word2 + "': " + findSentenceWithWord(sentences, word2));
    }
}

