package searching;

public class SearchAlgorithms {

    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];

        // Marking numbers that are in range as visited
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the first missing positive integer
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }

    // Function to perform Binary Search on a sorted array
    public static int binarySearch(int[] arr, int target) {
        //taking left and right pointers
        int left = 0, right = arr.length - 1;

        //while loop to search target element
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Main method
    public static void main(String[] args) {
        //Taking input
        int[] arr = {3, 4, -1, 1};
        //method calling for finding missing +ve number
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        //Taking sorted array
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        //Calling binary method
        int index = binarySearch(sortedArr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
