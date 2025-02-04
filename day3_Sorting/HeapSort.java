package day3_Sorting;

import java.util.Arrays;

public class HeapSort {

    // Method to implement Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Building a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extracting elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Calling max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at node i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Checking if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] salaryDemands = {55000, 70000, 48000, 65000, 80000, 60000};

        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));

        // Sorting
        heapSort(salaryDemands);

        // Displaying
        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}
