package searching;

public class RotationPointFinder {

    // Method to find the index of the smallest element
    public static int findRotationPoint(int[] arr) {

        //attributes
        int left = 0, right = arr.length - 1;

        // while loop to avoid integer overflow
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the last element, search in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Else, the smallest element must be in the left half including mid
            else {
                right = mid;
            }
        }
        // Left will point to the smallest element
        return left;
    }

    public static void main(String[] args) {
        //Taking number of exampels
        // Rotated at index 5
        int[] arr1 = {6, 7, 9, 15, 19, 2, 3};

        // Rotated at index 4
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};

        // No rotation
        int[] arr3 = {1, 2, 3, 4, 5};

        // Printing rotation points
        System.out.println("Rotation point index: " + findRotationPoint(arr1));
        System.out.println("Rotation point index: " + findRotationPoint(arr2));
        System.out.println("Rotation point index: " + findRotationPoint(arr3));
    }
}
