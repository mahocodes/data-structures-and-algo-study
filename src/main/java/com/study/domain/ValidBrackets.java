package com.study.domain;

import java.util.Stack;

public class ValidBrackets {

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    // 3. Every close bracket has a corresponding open bracket of the same type.
    // Example: input = "{}" result = true, input: "{(})" result = false

    // Solution
    // To solve this problem, you can use a stack data structure to keep track of the brackets that are still open.
    // We can iterate through the string, and for each open bracket, we can push it onto the stack.
    // For each closing bracket, you can check the top element of the stack to see if it is the corresponding open bracket.
    // If it is, you can pop the element off the stack. If it is not, or if the stack is empty, then the string is not valid.

    private static boolean isBracketClosingIncorrectly(char c, Character top) {
        return (c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{');
    }

    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        // we iterate through the array formed by each char in the String
        for (char c : s.toCharArray()) {
            // we push the open brackets into a stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                // if the brackets are closing, the opened bracket has to be at the top of the stack
                var top = stack.pop();

                if (isBracketClosingIncorrectly(c, top)) {
                    return false;
                }
            }
        }

        // we check if the stack is empty because we could still have an open bracket in the stack that was never closed
        return stack.isEmpty();
    }
}
