package com.study.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    // 1st solution
    // Write a function that takes in a "special" array and returns its product sum.
    // This array contains either integers or other arrays
    // The product sum is the sum of its elements considering the depth of the arrays inside of it
    // Ex.: [1, [2, 3]] is 1 + 2 * (2 + 3) = 11

    // Keep track of array depth by initializing a variable called multiplier
    // Go over the elements of the array with a for i loop using the instanceof function to check the element type
    // Complexity - 0(n) time, where n is the total number of elements in the array
    // O(d) space where d is the greatest depth of inner arrays
    public static int productSum(List<Object> array) {
        var multiplier = 1;

        return productSum(array, multiplier);
    }

    public static int productSum(List<Object> array, Integer multiplier) {
        int sum = 0;

        for (var element : array) {
            if (element instanceof ArrayList) {
                sum += productSum((ArrayList<Object>) element, multiplier + 1);
            } else {
                sum += Integer.parseInt(element.toString());
            }
        }

        return sum * multiplier;
    }

    // 2nd solution
    // Same complexity, just more clean
    public static int productSum2(List<Object> array) {
        return productSum2(array, 1);
    }

    public static int productSum2(List<Object> array, Integer multiplier) {
        int sum = 0;

        for (var element : array) {
            sum += element instanceof ArrayList ?
                    productSum2((ArrayList<Object>) element, multiplier + 1)
                    : Integer.parseInt(element.toString());
        }

        return sum * multiplier;
    }
}
