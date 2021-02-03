package com.tech.drools.models;

import java.io.Serializable;

public class TaxiRide implements Serializable {

    private Boolean isNightSurcharge = false;
    private Long distanceInMile = 0L;

    public TaxiRide() {
    }

    public TaxiRide(Boolean isNightSurcharge, Long distanceInMile) {
        this.isNightSurcharge = isNightSurcharge;
        this.distanceInMile = distanceInMile;
    }

    public Boolean isNightSurcharge() {
        return isNightSurcharge;
    }

    public void isNightSurcharge(Boolean nightSurcharge) {
        isNightSurcharge = nightSurcharge;
    }

    public Long getDistanceInMile() {
        return distanceInMile;
    }

    public void setDistanceInMile(Long distanceInMile) {
        this.distanceInMile = distanceInMile;
    }
}
