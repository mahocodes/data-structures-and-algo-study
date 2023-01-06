package com.study.domain;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotosService {

    // You are photographing the local school class. It has an even number of students.
    // Half of them wearing blue shirt and half wearing red shirt
    // Arrange the students in two rows following the guideline bellow:
    // 1. One row for the blue's
    // 2. One row for the red's
    // 3. Each student in the back row must be taller than the student in front oh him
    // Create a function that returns whether a class photo can be taken

    // Start ordering the students in descending order
    // Loop through the sorted input comparing each student

    // Complexity O(nlogn) where n is the number of students in one row and logn is complexity of the sorting method
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Collections.reverseOrder());
        blueShirtHeights.sort(Collections.reverseOrder());

        var backRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? redShirtHeights : blueShirtHeights;
        var frontRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? blueShirtHeights : redShirtHeights;

        for (int idx = 0; idx <= backRow.size(); idx++) {
            if (backRow.get(idx) < frontRow.get(idx)) {
                return false;
            }
        }

        return true;
    }
}
