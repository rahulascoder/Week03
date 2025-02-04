package day3_Sorting;

import java.util.Arrays;

public class InsertionSort {

    // Method to implement Insertion Sort
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        // Traversiing from the second element to the last
        for (int i = 1; i < n; i++) {
            // Pick an element from the unsorted part
            int key = employeeIDs[i];
            int j = i - 1;

            // Move elements of the sorted part that are greater than key
            // one position ahead of their current position
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }

            // Inserting the key into its correct position
            employeeIDs[j + 1] = key;
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 108, 103};

        System.out.println("Original Employee IDs: " + Arrays.toString(employeeIDs));

        // Sorting the employee IDs using Insertion Sort
        insertionSort(employeeIDs);

        // Displaying the sorted employee IDs
        System.out.println("Sorted Employee IDs: " + Arrays.toString(employeeIDs));
    }
}