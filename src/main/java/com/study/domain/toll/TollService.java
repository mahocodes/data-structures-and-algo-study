package com.study.domain.toll;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TollService {

    public void printTollFees(String licensePlate, List<TollRecord> records) {
        try {
            var tollFees = new AtomicInteger();

            System.out.println("Fees registered for the vehicle " + licensePlate);

            records.stream().filter(tollRecord -> tollRecord.getLicensePlate().equals(licensePlate))
                    .forEach(tollRecord -> {
                        tollFees.getAndIncrement();
                        System.out.println("1 x Regular Fee - $4.00");
                    });

            System.out.println("Total: $" + 4 * tollFees.get());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
