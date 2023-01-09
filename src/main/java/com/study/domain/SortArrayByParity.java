package com.study.domain;

import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] arrayA) {
        // Time complexity of O(nlogn) where n is the length of the array
        // Space complexity of O(n) (for the sorting)

        var arrayB = new Integer[arrayA.length];
        for (int t = 0; t < arrayA.length; ++t)
            arrayB[t] = arrayA[t];

        Arrays.sort(arrayB, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int t = 0; t < arrayA.length; ++t)
            arrayA[t] = arrayB[t];
        return arrayA;

        /* Alternative:
        return Arrays.stream(arrayA)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }
}
