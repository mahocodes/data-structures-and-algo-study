package com.study.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareArrayElementsService {

    // Write a function that takes in a non-empty array of integers that are sorted in ascending order
    // and returns a new array of the same length with the squares of the original integers also sorted in ascending order.
    // For instance [1, 2, 3, 5, 6, 8, 9] returns [1, 4, 9, 25, 36, 64, 81]
    // Complexity O(nlogn) => 'cause we visit each element of the array with N elements once and sort using quicksort (which has complexity O(logn) )
    public int[] squareArrayElements(int[] array) {
        var squaredArray = new int[array.length];

        if (array.length == 1) {
            return new int[]{array[0] * array[0]};
        }

        for (var idx = 0; idx < array.length; idx++) {
            var value = array[idx];

            squaredArray[idx] = value * value;
        }

        Arrays.sort(squaredArray, 0, squaredArray.length);

        return squaredArray;
    }

    // 2nd solution
    // Use two pointers to keep track of the smallest and greatest values, so we can insert the elements ate the correct order (avoiding sorting)
    // Ex: [-7, 1, 4, 8] we compare 7 and 8. 7² will be less than 8², so we add the result of 8² to the end of the list and move the right pointer to the left
    // Next whe compare 7 and 4. Because 7 is greater than 4, we add the result of 7² to the end of the list and move the left pointer to the right
    // Complexity O(n) => we visit each element of the array of N elements once
    public int[] squareArrayElements2(int[] array) {
        var maxIdx = array.length - 1;

        var left = 0;
        var right = maxIdx;

        var squaredArray = new int[array.length];

        for (var i = 0; i < array.length; i++) {
            if (Math.abs(array[left]) > Math.abs(array[right])) {
                squaredArray[maxIdx - i] = array[left] * array[left];
                left++;
            } else {
                squaredArray[maxIdx - i] = array[right] * array[right];
                right--;
            }
        }

        return squaredArray;
    }
}
