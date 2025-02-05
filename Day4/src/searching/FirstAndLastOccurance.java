package searching;

public class FirstAndLastOccurance {

    // Method to find the first occurrence of the target
    public static int findFirst(int[] arr, int target) {
        //Taking left and right pointer
        int left = 0, right = arr.length - 1, first = -1;

        //while loop to find the first occurrence
        while (left <= right) {
            //finding mid position
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // Storing the index and searching on the left side
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    // Method to find the last occurrence of the target
    public static int findLast(int[] arr, int target) {
        //Taking left and right pointer
        int left = 0, right = arr.length - 1, last = -1;

        //while loop to find the last occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Storing the index and searching on the right side
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    // Main function to find the first and last occurrence of the target
    public static int[] findFirstAndLast(int[] arr, int target) {
        //Method calling to find first and last occurrence
        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        //returning first and last index in array
        return new int[]{first, last};
    }

    // Main method
    public static void main(String[] args) {

        //Input
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        //target value
        int target = 2;
        int[] result = findFirstAndLast(arr, target);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}
