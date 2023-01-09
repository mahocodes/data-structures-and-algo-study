package com.study.domain;

public class ClimbingStair {

    // You are climbing a staircase. It takes n steps to reach the top.
    // Each time you can either climb 1 or 2 steps.
    // Write a function that takes the amount of steps in the staircase and return how many ways you can climb the staircase.

    // 1st Solution
    // We will take a page from Fibonacci's sequence book, as the number of ways to climb the stairs is
    // the sum of the number of ways to climb the stairs for the previous two steps.
    // For example, the number of ways to climb 3 stairs is the sum of the number of ways to climb 2 stairs and the number of ways to climb 1 stair.
    // For the first solution we will use recursion.
    // Base case: when there is only 1 stair or 2 stairs, in which there is only 1 and 2 ways to climb them, respectively.
    // Time complexity is O(2^n) because each call branches into two other calls for n calls.
    // Note: it is not optimal for greater inputs
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    // 2nd solution
    // Non-recursive solution
    // This solution uses a loop to iterate through the number of stairs from 3 to n (cause 1 and 2 are the base cases),
    // updating the number of ways to climb the stairs at each step by adding the number of ways to climb the stairs for the previous two steps.
    // The base cases are still when there is only 1 stair or 2 stairs, in which there is only 1 way or 2 ways to climb them respectively.
    // Time complexity is O(n) as the loop will run a maximum of n times.
    // It is more efficient than the recursive solution for larger values of n.
    public int climbStairs2(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        var numberOfWays = new int[n + 1];
        numberOfWays[0] = 1;
        numberOfWays[1] = 1;

        for (int i = 2; i <= n; i++) {
            numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2];
        }

        return numberOfWays[n];
    }
}
