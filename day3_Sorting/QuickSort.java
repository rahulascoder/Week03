package day3_Sorting;

import java.util.Arrays;

public class QuickSort {

    // Method to implement Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partitioning the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively applying Quick Sort on left and right partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Method to partition the array
    public static int partition(int[] prices, int low, int high) {
        // Choosing the last element as pivot
        int pivot = prices[high];
        // Pointer for the smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swaping
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swaping pivot element to its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Main method
    public static void main(String[] args) {
        int[] productPrices = {599, 199, 899, 299, 499, 799};

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));

        // Sorting the product prices
        quickSort(productPrices, 0, productPrices.length - 1);

        // Displaying the sorted product prices
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
