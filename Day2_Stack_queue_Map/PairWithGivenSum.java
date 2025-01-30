import java.util.*;

public class PairWithGivenSum {
    // Method to check if there exists a pair with the given sum
    public static boolean hasPairWithSum(int[] nums, int target) {
        // HashSet to store visited numbers
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Calculating the required complement
            int complement = target - num;

            // If complement exists in the set, a pair is found
            if (seen.contains(complement)) {
                return true;
            }

            // Adding the current number to the set
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 12, 9};
        int target = 13;

        if (hasPairWithSum(nums, target)) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum found.");
        }
    }
}