package com.study.domain.toll;

import java.time.LocalDateTime;

public class TollRecord {

    private String licensePlate;

    private String tollId;

    private LocalDateTime dateTime;

    public TollRecord(String licensePlate, String tollId, LocalDateTime dateTime) {
        this.licensePlate = licensePlate;
        this.tollId = tollId;
        this.dateTime = dateTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTollId() {
        return tollId;
    }

    public void setTollId(String tollId) {
        this.tollId = tollId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
