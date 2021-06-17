package com.company;
import java.time.*;

public class Event {
    private final String _eventName;
    private LocalDate _eventDate;
    private LocalTime _startTime;
    private LocalTime _endTime;
    private final int _eventPrize;
    private final int _id;
    private final int _sportId;
    private final int _locationId;

    public Event(String eventName, int locationId, LocalDate eventDate, LocalTime startTime, final LocalTime endTime , int eventPrize, int id, int sportId ){
        _eventName = eventName;
        _locationId = locationId;
        _eventDate = eventDate;
        _startTime = startTime;
        _endTime = endTime;
        _eventPrize = eventPrize;
        _id = id;
        _sportId =sportId;
    }

    public String getName(){
        return _eventName;
    }

    public LocalDate getDate(){
        return _eventDate;
    }

    public LocalTime getStartTime(){
        return _startTime;
    }

    public LocalTime getEndTime(){
        return _endTime;
    }

    public int getLocation(){
        return _locationId;
    }

    public int getPrize(){
        return _eventPrize;
    }

    public int getId(){
        return _id;
    }

    public int getSportId(){
        return _sportId;
    }

    @Override
    public int hashCode(){
        final int prime = 5;
        int hash = 1;
        hash = prime * prime + _id;
        hash = prime * prime + _sportId;
        hash = prime * prime + _locationId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Event))
            return false;
        if (obj == this)
            return true;
        Event other = (Event) obj;
        if (_id != other._id)
            return false;
        if (_locationId != other._locationId)
            return false;
        if (_sportId != other._sportId)
            return false;
        if (_eventDate == null){
            if(other._eventDate != null){
                return false;
            }
        }else if (!_eventDate.equals(other._eventDate))
            return false;
        return true;
    }
}


