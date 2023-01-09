package com.study.domain;

public class ReverseWordsString {


    // Write a function that takes in a string of words separated by one or more whitespaces and returns a string that
    // has these words in reverse order.
    // For example, given the string "tim is great", your function should return "great is tim".
    // Methods not allowed: split and reverse, but you could use join
    // Also note that the input string isn't guaranteed to always contain words.

    // Solution
    // Create two string builders to keep track of th reversed words and the current word
    // Traverse the array of char from end to start. If the current char is a space, we are going to append the word,
    // followed by a space and reset the variable currentWord. If it is a letter, we increment the currentWord.
    // Finally, we return the reversed word, and the current word (that we did not append to the string builder yet)

    // Time/Space Complexity O(n) where n is the number of char in the string
    public String reverseWordsInString(String string) {
        var reverse = new StringBuilder();
        var currentWord = new StringBuilder();

        var i = string.length() - 1;

        while (i >= 0) {
            var currentChar = string.charAt(i);

            if (currentChar == ' ') {
                reverse.append(currentWord).append(" ");
                currentWord = new StringBuilder();
            } else {
                currentWord.insert(0, currentChar);
            }

            i--;
        }

        return reverse.toString() + currentWord;
    }
}
