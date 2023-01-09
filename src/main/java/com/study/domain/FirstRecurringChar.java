package com.study.domain;

import java.util.HashMap;

public class FirstRecurringChar {

    // Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the
    // string's first repeating character.
    // The first repeating character is the first character in a string that occurs more than once.
    // If the input string doesn't have any non-repeating characters, your function should return -1.

    // Solution
    // Create a hashmap to keep track of every char we see
    // Iterate through the array of char collecting every character visited
    // Check if the current char is already in the map

    // O(n) time | O(1) space - where n is the length of the input string
    // The constant space is because the input string only has lowercase English-alphabet letters;
    // thus, our hash table will never have more than 26 character frequencies.
    public int firstRecurringChar(String string) {
        var map = new HashMap<Character, Integer>();

        var array = string.toCharArray();

        for (int i = 0; i < array.length; i++) {
            var key = array[i];

            if (map.containsKey(key)) {
                return i;
            } else {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        return -1;
    }
}
