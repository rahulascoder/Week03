package searching;

public class FirstNegativeNumber {

    // Method to find the index of the first negative number
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Checking if the current element is -ve
            if (arr[i] < 0) {
                return i;
            }
        }
        // If no negative number is found
        return -1;
    }

    //main method
    public static void main(String[] args) {

        //taking 3 arrays for testing
        int[] numbers1 = {3, 7, 2, -5, 9, -2};
        int[] numbers2 = {1, 4, 6, 8, 10};
        int[] numbers3 = {-3, 5, -1, 7};

        // output
        System.out.println("Index of first negative number: " + findFirstNegative(numbers1) );
        System.out.println("Index of first negative number: " + findFirstNegative(numbers2)+" means no -ve number found in array");
        System.out.println("Index of first negative number: " + findFirstNegative(numbers3));
    }
}
