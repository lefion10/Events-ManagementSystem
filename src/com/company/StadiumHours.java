package com.company;

import java.time.LocalTime;

public class StadiumHours {
    private final LocalTime _openingHour;
    private final LocalTime _closingHour;

    public StadiumHours(LocalTime openingHour) {
        _openingHour = LocalTime.of(8,30);
        _closingHour = LocalTime.of(23,30);
    }

    public LocalTime getOpeningHour(){
        return _openingHour;
    }

    public LocalTime getClosingHour(){
        return _closingHour;
    }
}
