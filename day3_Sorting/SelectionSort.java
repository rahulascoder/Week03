package day3_Sorting;

import java.util.Arrays;

public class SelectionSort {

    // Method to implement Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traversing through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            // Finding the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swaping the found minimum element with the first element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] examScores = {85, 72, 90, 65, 78, 88};

        System.out.println("Original Exam Scores: " + Arrays.toString(examScores));

        // method calling to sort stack
        selectionSort(examScores);

        // Displaying the sorted exam scores
        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));
    }
}

