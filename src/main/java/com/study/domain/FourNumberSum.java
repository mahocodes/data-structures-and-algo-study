package com.study.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourNumberSum {

    // Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
    // The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional
    // array of all these quadruplets in no particular order.
    // If no four numbers sum up to the target sum, the function should return an empty array.
    // Example: array = [7, 6, 4, -1, 1, 2] and targetSum = 16 gives us the result [[7, 6, 4, -1], [7, 6, 1, 2]]

    // Solution
    // For the two sum function, we used y = 10 - x to insert the number into the hashmap
    // For this problem, we can assume that x = P + Q where P and Q are sums of two numbers
    // In the example 7 + 6 sum up to 13. So we store the key 13 in the hash map with the array [7, 6]
    // If we find another two numbers that sum up to 13, than we should store that in the same array list of the existing key 13

    // Complexity
    // Time O(n²) avg time and O(n³) at worst case scenario (Avg is for the most cases)
    // Space O(n²) where we store n elements n times
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        var allPairSums = new HashMap<Integer, List<Integer[]>>();
        var quadruplets = new ArrayList<Integer[]>();

        // iterate through all the numbers
        for (int i = 1; i < array.length - 1; i++) {
            // iterate through all numbers after the current number
            for (int j = i + 1; j < array.length; j++) {
                // we sum these two numbers and check the difference between the sum and the target
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                // if there is another pair stored that matches that difference, we can build one quadruplet
                if (allPairSums.containsKey(difference)) {
                    // for every pair of sum that matches the difference we're looking for, we create a new quadruplet
                    for (Integer[] pair : allPairSums.get(difference)) {
                        var newQuadruplet = new Integer[]{pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }

            // iterate through all the numbers before the current number
            for (int k = 0; k < i; k++) {
                // we sum the two numbers and pair them
                int currentSum = array[i] + array[k];
                var pair = new Integer[]{array[k], array[i]};
                // we check if that currentSum key is not in the hash table and add it to the hash table
                if (!allPairSums.containsKey(currentSum)) {
                    var pairGroup = new ArrayList<Integer[]>();
                    pairGroup.add(pair);
                    allPairSums.put(currentSum, pairGroup);
                    // if the currentSum is already in the hash table, we just insert the pair into the existing key
                } else {
                    allPairSums.get(currentSum).add(pair);
                }
            }
        }
        return quadruplets;
    }
}
