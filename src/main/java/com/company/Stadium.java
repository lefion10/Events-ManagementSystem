package com.company;

import java.time.LocalTime;

public class Stadium{
    private final LocalTime _openingHour;
    private final LocalTime _closingHour;
    private int _locationId;

    public Stadium(int locationId) {
        _openingHour = LocalTime.of(8,30);
        _closingHour = LocalTime.of(23,30);
        _locationId = locationId;
    }

    public LocalTime getOpeningHour(){
        return _openingHour;
    }

    public LocalTime getClosingHour(){
        return _closingHour;
    }

    public int getLocationId(){
        return _locationId;
    }

    public void setLocationId(int locationId) {
        this._locationId = locationId;
    }

}
