package com.company;

import java.time.*;
import java.util.*;


public class Scheduler {
    private final Map<LocalDate,List<Event>> events = new HashMap<>();
    private StadiumHours stadiumHours;

    public void scheduleEvent(Event event){
        LocalDate eventDate = event.getDate();
        LocalTime startTime = event.getStartTime();
        LocalTime endTime = event.getEndTime();

        if (validEvent(startTime,endTime)){
            scheduleEvent(event, eventDate, startTime, endTime);
        }
    }

    //  Compares the event hours with the available stadium hours
    private boolean validEvent(LocalTime startTime , LocalTime endTime){
      return programCheck(startTime, stadiumHours.getOpeningHour(), stadiumHours.getClosingHour())
              && programCheck(endTime, stadiumHours.getOpeningHour(), stadiumHours.getClosingHour());
    }

    // Checks if two events are in conflicting hours
    private boolean conflictsWith(LocalTime startTime, LocalTime endTime, LocalTime currentStartTime, LocalTime currentEndTime) {
        return (startTime.equals(currentStartTime) && endTime.equals(currentEndTime)) || (programCheck(currentStartTime, startTime, endTime)
                || programCheck(currentEndTime, startTime, endTime));
    }

    private boolean programCheck(LocalTime targetTime, LocalTime startTime, LocalTime endTime) {
        return targetTime.isAfter(startTime) && targetTime.isBefore(endTime);
    }

    // Searches for a conflicting event
    private Optional<Event> findConflictingEvent(LocalTime startTime, LocalTime endTime, List<Event> eventList) {
        return eventList.stream()
                .filter(events -> conflictsWith(events.getStartTime(), events.getEndTime(), startTime, endTime))
                .findAny();
    }

    private void scheduleEvent(Event event, LocalDate eventDate, LocalTime startTime,  LocalTime endTime){
        List<Event> eventsList = events.get(eventDate);

        if(eventsList == null){
            eventsList = new ArrayList<>();
            eventsList.add(new Event(event.getName(),event.getLocation(), eventDate, startTime, endTime, event.getPrize(), event.getId(), event.getSportId()));
            events.put(eventDate,eventsList);
        }else{
            Optional<Event> conflictingEvent = findConflictingEvent(startTime, endTime, eventsList);

            if(!conflictingEvent.isPresent()){
                eventsList.add(new Event(event.getName(),event.getLocation(), eventDate, startTime, endTime, event.getPrize(), event.getId(), event.getSportId()));
            }
        }
    }

    public Map<LocalDate,List<Event>>getEvents(){
        return events;
    }
}
