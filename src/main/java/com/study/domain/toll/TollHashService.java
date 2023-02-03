package com.study.domain.toll;

import java.util.HashMap;

public class TollHashService {

    // the complexity would be constant time on avg for adding a toll record and for printing the records.
    // thats because hash tables consist on indexing records through a hash function
    // which means that this operations will remain efficient even as the number of records grows.
    // it is very efficient in terms of time complexity
    // but as the number of records grows, the space complexity would also grow linearly.
    // So for the space complexity we would have O(n) where n is the number of unique license plates recorded.

    private HashMap<String, Integer> tollRecords;

    public TollHashService() {
        tollRecords = new HashMap<>();
    }

    public void addTollRecord(String licensePlate) {
        tollRecords.put(licensePlate, tollRecords.getOrDefault(licensePlate, 0) + 1);
    }

    public void printTollFees(String licensePlate) {
        // we avoid null pointers with default value
        var tollFees = tollRecords.getOrDefault(licensePlate, 0);

        System.out.println("Fees registered for the vehicle " + licensePlate);

        for (int i = 0; i <= tollFees; i++) {
            System.out.println("1 x Regular Fee - $4.00");
        }

        System.out.println("Total: $" + 4 * tollFees);
    }
}
