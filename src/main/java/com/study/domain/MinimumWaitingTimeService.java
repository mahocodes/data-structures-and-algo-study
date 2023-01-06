package com.study.domain;

public class MinimumWaitingTimeService {

    // You're given a non-empty array of positive integers representing the amounts of time that specific queries take to execute.
    // Only one query can be executed at a time, but the queries can be executed in any order.
    // Waiting time = amount of time they wait before its execution starts (sum of the duration of previous queries)

    // Create a variable to store the total waiting time, and iterate through the sorted input array.
    // At each iteration, multiply the number of queries left by the duration of the current query, and add that to the total waiting time.

    // Complexity 0(n) where n is the number of elements in the array
    public int minimumWaitingTime(int[] queries) {
        var totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {
            var duration = queries[i];

            var queriesLeft = queries.length - (i +1);

            totalWaitingTime += queriesLeft * duration;
        }

        return totalWaitingTime;
    }

}
