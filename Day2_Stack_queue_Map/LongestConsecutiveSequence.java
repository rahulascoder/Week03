import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        // Create a HashSet to store unique elements from the array
        HashSet<Integer> numSet = new HashSet<>();

        // Adding all elements of the array to the HashSet
        for (int num : nums) {
            numSet.add(num);
        }

        // Variable to store the length of the longest consecutive sequence
        int longestSequence = 0;

        // Iterate through each element in the array
        for (int num : nums) {
            // Checking if the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                //checking for the next consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Updating the longest sequence length if a longer one is found
                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }

        // Returning the length of the longest consecutive sequence
        return longestSequence;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        // Calling  function and print the result
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums));
    }
}
