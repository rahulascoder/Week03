package day3_Sorting;

import java.util.Arrays;

public class CountingSort {

    // Method to implement Counting Sort
    public static void countingSort(int[] ages) {
        //attributes
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        // Output array for sorted values
        int[] output = new int[ages.length];

        // Counting occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Computing cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in correct positions in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method
    public static void main(String[] args) {
        int[] studentAges = {12, 14, 10, 18, 11, 15, 13, 12, 16, 14};

        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));

        // Sorting the student ages
        countingSort(studentAges);

        // Displaying  
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}
