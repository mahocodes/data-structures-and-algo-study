package com.study.domain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class TandemBicycleService {

    // A tandem bicycle is a bicycle that's operated by two people: person A and person B.
    // The bicycle total speed is speed of the fastest person
    // You've given two arrays of riders: red and blue, each represented by its speed
    // Goal is to pair one red and one blue
    // Write a function that returns the max or min total speed depending on the flag 'fastest'
    // Total speed = sum of speeds of all the bicycle being ridden

    // When returning max possible speed, pair the fastest red with the slowest blue
    // In min possible speed, pair the fastest of each team

    // Example: [5, 3, 5, 9, 2] and [2, 6, 3, 1, 7]
    // Order: [2, 3, 5, 5, 9] and [1, 2, 3, 6, 7] (or [7, 6, 3, 2, 1] for the min possible)
    // The sum is:
    //    - max: 9 + 5 + 5 + 6 + 7 = 32
    //    - min: 1 + 2 + 3 + 6 + 7 = 18
    // Note: we reverse the second array to pair the fastest
    // Complexity 0(nlogn) where n is the number of riders in each team and logn is complexity of the sorting method
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds, 0, redShirtSpeeds.length);
        Arrays.sort(blueShirtSpeeds, 0, blueShirtSpeeds.length);

        if (!fastest) {
            reverseArray(redShirtSpeeds);
        }

        var totalSpeed = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            var rider1 = redShirtSpeeds[i];
            var rider2 = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            totalSpeed += Math.max(rider1, rider2);
        }

        return totalSpeed;
    }

    private void reverseArray(int[] array) {
        var start = 0;
        var end = array.length - 1;

        while (start < end) {
            var temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}
