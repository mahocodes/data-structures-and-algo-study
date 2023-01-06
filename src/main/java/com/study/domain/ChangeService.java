package com.study.domain;

import java.util.Arrays;

public class ChangeService {

    // Given an array of positive integers representing the values of coins in your possession, write a function that returns
    // the minimum amount of change (the minimum sum of money) that you CANNOT create.
    // The given coins can have any positive integer value and aren't necessarily unique.
    // Ex: [1, 1, 2] you can make 1, 2, 3, 4... but you cannot make 5!
    // Complexity O(nlogn) where n is the amount of coins in the array and logn is the complexity of the sorting algorithm
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins, 0, coins.length);

        var change = 0;

        if (coins.length == 0) {
            return 0;
        }

        for (int coin : coins) {
            if (coin > change + 1) {
                return change + 1;
            }

            change += coin;
        }

        return change + 1;
    }
}
