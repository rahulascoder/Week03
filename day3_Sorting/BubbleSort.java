package day3_Sorting;

import java.util.Arrays;

public class BubbleSort {

    // Method to implement Bubble Sort
    public static void bubbleSort(int[] marks) {
        //length of array
        int n = marks.length;
        boolean swapped;

        // Traversing through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            // Tracking if any swaps happen in this iteration
            swapped = false;

            // Comparing adjacent elements and swaps if needed
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {

                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred
            if (!swapped) {
                break;
            }
        }
    }

    // Main method to test Bubble Sort
    public static void main(String[] args) {
        int[] studentMarks = {85, 78, 92, 65, 89, 74};

        System.out.println("Original Marks: " + Arrays.toString(studentMarks));

        // Sorting the marks using Bubble Sort
        bubbleSort(studentMarks);

        // Displaying the sorted marks
        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
    }
}
