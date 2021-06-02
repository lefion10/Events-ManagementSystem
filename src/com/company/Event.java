package com.company;
import java.util.*;

public class Event {
    private String eventName ;
    private String eventLocation ;
    private String eventDate;
    private int eventPrize;
    private int eventCost;
    private static int organizingCost = 0;
//    Event ID
    private static int id = 1000;
    private int eventSport ;
    private int eventId = 0;

//    Event constructor

    public Event(){
        id++;
        Scanner snc = new Scanner(System.in);

        System.out.println("Event name: ");
        this.eventName = snc.nextLine();

        System.out.println("Event location: ");
        this.eventLocation = snc.nextLine();

        System.out.println("Event Date: ");
        this.eventDate = snc.nextLine();

        System.out.println("1 - Chess \n2 - Tennis \n3 Basketball \n4 Soccer : ");
        try{
            do{
                this.eventSport = snc.nextInt();
                if(eventSport > 0 && eventSport < 5){
                    break;
                }
                else{
                    continue;
                }
            }
            while(true);
        }
        catch (Throwable throwable){
            System.out.println("You did not choose one of the options");
        }

        System.out.println("Event Prize: ");
        try{
            this.eventPrize = snc.nextInt();
        }
        catch (Throwable throwable){
            System.out.println("You did not choose a valid amount");
        }

        setEventId();
        setOrganizingCost();
        getInfo();


    }

    private void setEventId(){
        this.eventId = eventSport + id;
        System.out.println("The Id of the event is: " + eventId );
    }


    public void setOrganizingCost(){
        Scanner snc = new Scanner(System.in);

        System.out.println("Number of players: ");
        int playersNumb = snc.nextInt();

        System.out.println("Number of seats: ");
        int seatsNumb = snc.nextInt();

        System.out.println("Duration of the event: ");
        int eventDuration = snc.nextInt();

        this.eventCost = playersNumb * 100 + seatsNumb * 10 + eventDuration * 50 + eventPrize;
        System.out.println("The cost of the event is : " + eventCost + "$" );

    }

    public void getInfo() {
        switch (eventSport) {
            case 0:
                System.out.println(eventName + " is an Sport event , starting at " + eventDate + " at " + eventLocation);
            case 1:
                System.out.println(eventName + " is an Chess event , starting at " + eventDate + " at " + eventLocation);
            case 2:
                System.out.println(eventName + " is an Tennis event , starting at " + eventDate + " at " + eventLocation);
            case 3:
                System.out.println(eventName + " is an Basketball event , starting at " + eventDate + " at " + eventLocation);
            case 4:
                System.out.println(eventName + " is an Soccer event , starting at " + eventDate + " at " + eventLocation);
            default:
                System.out.println("There s no information about this event");
        }
    }

    public int getId(){
        return id;
    }

    public int hashCode(){
        return id;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Event))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((Event) obj).getId();
    }


}


