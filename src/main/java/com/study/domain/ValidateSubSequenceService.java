package com.study.domain;

import java.util.List;
import java.util.Objects;


public class ValidateSubSequenceService {

    // Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.
    // A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array.
    // For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].
    // Note that a single number in an array and the array itself are both valid subsequences of the array.
    // Example:
    // array = [5, 1, 22, 25, 6, -1, 8, 10]
    // sequence = [1, 6, -1, 10] ===> TRUE

    // 1st solution
    // we place pointers and loop through the arrays checking each element
    // Complexity O(n) => Linear complexity 'cause we visit each element once worst case scenario
    public boolean isSubsequenceValid(List<Integer> arr, List<Integer> sequence) {
        var arrIdx = 0;
        var seqIdx = 0;

        while (arrIdx < arr.size() && seqIdx < sequence.size()) {
            if (Objects.equals(arr.get(arrIdx), sequence.get(seqIdx))) {

                seqIdx += 1;
            }
            arrIdx += 1;
        }
        return seqIdx == sequence.size();
    }

    public boolean isSubsequenceValidFor(List<Integer> arr, List<Integer> sequence) {
        var seqIdx = 0;

        for (var integer : arr) {
            if (seqIdx == sequence.size()) {
                return true;
            }

            if (Objects.equals(sequence.get(seqIdx), integer)) {
                seqIdx += 1;
            }
        }

        return seqIdx == sequence.size();
    }
}
