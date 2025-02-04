package day3_Sorting;

import java.util.Arrays;

public class MergeSort {

    // Method to implement Merge Sort
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted halves
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Creating temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copying data to temporary arrays
        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);

        // Merging the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copying remaining elements of leftArray[]
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copying remaining elements of rightArray[]
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] bookPrices = {450, 200, 700, 100, 550, 300};

        System.out.println("Original Book Prices: " + Arrays.toString(bookPrices));

        // Sorting the book prices using Merge Sort
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        // Displaying the sorted book prices
        System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
    }
}
