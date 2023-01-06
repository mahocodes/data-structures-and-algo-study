package com.study.domain.bst;

public class BinarySearchByTarget {

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        var middle = (left + right) / 2;
        var probMatch = array[middle];

        if (target == probMatch) {
            return middle;
        } else if (target < probMatch) {
            return binarySearch(array, target, left, middle - 1);
        } else {
            return binarySearch(array, target, middle + 1, right);
        }
    }
}
