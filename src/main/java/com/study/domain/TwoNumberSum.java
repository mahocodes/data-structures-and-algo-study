package com.study.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoNumberSum {

    // Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
    // If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order.
    // If no two numbers sum up to the target sum, the function should return an empty array.
    // Note that the target sum has to be obtained by summing two different integers in the array;
    // You can't add a single integer to itself in order to obtain the target sum.
    // You can assume that there will be at most one pair of numbers summing up to the target sum.

    // Basically, we have the following function x + y = 10
    // Also y = 10 - x

    // 1st solution 
    // nested for loop to iterate over x and y
    // Complexity 0(n²) => 'cause we iterate the array of N numbers twice
    public int[] twoNumberSum(int[] array, Integer targetSum) {
        for (int x = 0; x < array.length - 1; x++) {
            var currentNumber = array[x];
            for (int y = x + 1; y < array.length; y++) {
                var secondNumber = array[y];

                if (currentNumber + secondNumber == targetSum) {
                    return new int[]{currentNumber, secondNumber};
                }
            }
        }

        return new int[]{};
    }

    // 2nd solution
    // hashtable to store each visited elements
    // If y = 10 - x then we iterate through the array checking if y is in the hashtable
    // Complexity O(n) => 'cause we visit each element of the array once at the worst case scenario
    public static int[] twoNumberSum2(int[] array, Integer targetSum) {
        var numsHashTable = new ArrayList<Integer>();

        for (int currentNumber : array) {
            var y = targetSum - currentNumber;

            if (numsHashTable.contains(y)) {
                return new int[]{currentNumber, y};
            } else {
                numsHashTable.add(currentNumber);
            }
        }

        return new int[]{};
    }

    // 3rd solution
    // sort the array -> quickSort
    // for loop to check using two pointers
    // ex [-4, -1, 1, 3, 8, -11, 30]
    // -4, 30 (one pointer at each end of the array)
    // Check if 26 (currentSum) < 10 (targetSum) to choose which pointer to move (in this case, the right pointer to the left) to a smaller sum.
    // Complexity 0(nlogn) => elements are ordered at logn complexity and visit each element of n elements

    public static int[] twoNumberSum3(int[] array, Integer targetSum) {
        Arrays.sort(array, 0, array.length);

        var left = 0;
        var right = array.length - 1;

        while (left < right) {
            var currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                return new int[] {array[left], array[right]};
            } else if (currentSum < targetSum) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return new int[]{};
    }
}
