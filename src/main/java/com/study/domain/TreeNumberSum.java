package com.study.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNumberSum {

    // Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
    // If any tree numbers in the input array sum up to the target sum, the function should return them in an array, in any order.
    // If no tree numbers sum up to the target sum, the function should return an empty array.
    // Note that the target sum has to be obtained by summing tree different integers in the array;
    // You can't add a single integer to itself in order to obtain the target sum.
    // You can assume that there will be at most one triplet of numbers summing up to the target sum.

    // Using left and right pointers to traverse the sorted array, we will
    // Assume that target = currentNumber + left pointers number + right pointers number
    // With the sorted list, if the target sum is greater than the current sum, we move the left pointer up to increase the sum
    // If the target is smaller, we move the right pointer down to decrease the current sum

    // Time complexity of O(n^2) and space of O(n) where n is the size of the input array
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        var finalList = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            var left = i + 1;
            var right = array.length - 1;

            while (left < right) {
                var currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    finalList.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return finalList;
    }

}
