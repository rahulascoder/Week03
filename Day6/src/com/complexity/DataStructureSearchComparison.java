package com.complexity;

import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        //Taking one million data
        int n = 1000000;
        //Taking random number
        Random rand = new Random();
        int target = rand.nextInt(n);

        //array
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        long startArray = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long endArray = System.nanoTime();
        System.out.println("Array Search Time: " + (endArray - startArray) / 1e6 + " ms");

        // HashSet search for constant O(1) time complexity
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) / 1e6 + " ms");

        // TreeSet search for log(N) complexity
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) / 1e6 + " ms");
    }

    //  Linear search O(n) time complexity
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
