package com.complexity;

public class FibonacciComparison {

    // Recursive approach for calculating exponential time complexity of fibonacci
    public static int fibonacciRecursive(int n) {

        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach for calculating linear time complexity of fibonacci
    public static int fibonacciIterative(int n) {

        if (n == 0) return 0;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 10;

        // Measuring time taken by recursive approach
        long startRecursive = System.nanoTime();
        int fibRecursive = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + ") = " + fibRecursive);
        System.out.println("Time taken (Recursive): " + (endRecursive - startRecursive) / 1e6 + " ms");

        // Measuring time taken by iterative approach
        long startIterative = System.nanoTime();
        int fibIterative = fibonacciIterative(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + ") = " + fibIterative);
        System.out.println("Time taken (Iterative): " + (endIterative - startIterative) / 1e6 + " ms");
    }
}
