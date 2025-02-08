package com.complexity;

public class StringConcatenationPerformance {

    // Using String  to check concatenation time of string
    public static void testStringConcatenation(int n) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < n; i++) {

            //String is immutable so here new object is created each time so it take more time than stringBilder or buffer
            result += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Using StringBuilder for checking concatenation time of string
    public static void testStringBuilderConcatenation(int n) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Using StringBuffer for checking concatenation time of string
    public static void testStringBufferConcatenation(int n) {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    public static void main(String[] args) {
        // Number of concatenations
        int n = 1000000;
        System.out.println("Concatenating " + n + " strings...\n");

        // calling method to check time
        testStringConcatenation(100000);
        testStringBuilderConcatenation(n);
        testStringBufferConcatenation(n);
    }
}

