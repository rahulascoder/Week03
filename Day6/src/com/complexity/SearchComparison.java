package com.complexity;

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Method for linear Search complexity
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Method for binary Search complexity
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {

            //finding mid value
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    //main method
    public static void main(String[] args) {

        //Taking different size of dataset
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] dataset = new int[size];

            // Generating random numbers
            for (int i = 0; i < size; i++) {
                dataset[i] = rand.nextInt(size * 10);
            }

            // Picking a random target
            int target = dataset[rand.nextInt(size)];

            // Measuring linear Search time
            long startTime = System.nanoTime();
            linearSearch(dataset, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            // Sorting dataset for Binary Search
            Arrays.sort(dataset);

            // Measuring Binary Search time
            startTime = System.nanoTime();
            binarySearch(dataset, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            // Showing result
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1e6 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1e6 + " ms");

        }
    }
}
