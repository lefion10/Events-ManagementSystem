package com.company;
import java.util.*;

public class Event {
    private final String _eventName;
    private final String _eventDate;
    private final int _eventPrize;
    private final int _id;
    private final int _sportId;
    private final int _locationId;

    public Event(String eventName, int locationId, String eventDate, int eventPrize, int id, int sportId ){
        _eventName = eventName;
        _locationId = locationId;
        _eventDate = eventDate;
        _eventPrize = eventPrize;
        _id = id;
        _sportId =sportId;
    }

    public String getName(){
        return _eventName;
    }

    public String getDate(){
        return _eventDate;
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


