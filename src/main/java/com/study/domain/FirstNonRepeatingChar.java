package com.study.domain;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    // Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the
    // string's first non-repeating character.
    // The first non-repeating character is the first character in a string that occurs only once.
    // If the input string doesn't have any non-repeating characters, your function should return -1.

    // Solution
    // Create a hashmap to keep track of every char and how many times they appear in the string
    // Iterate through the array of char and collect every character incrementing the map value every time we see the same char
    // One iteration through the array checking if map value is equal to one and the found index

    // O(n) time | O(1) space - where n is the length of the input string
    // The constant space is because the input string only has lowercase English-alphabet letters;
    // thus, our hash table will never have more than 26 character frequencies.
    public int firstNonRepeatingCharacter(String string) {
        var map = new HashMap<Character, Integer>();

        var array = string.toCharArray();

        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
