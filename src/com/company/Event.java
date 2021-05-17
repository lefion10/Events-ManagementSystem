package com.company;
import java.util.Scanner;

public class Event {
    private String eventName ;
    private String eventLocation ;
    private String eventDate;
    private int eventPrize;
    private int eventCost;
    private static int organizingCost = 0;
//    Event ID
    private static int id = 0;
    private int eventSport ;
    private int eventId = 0;

//    Event constructor

    public Event() throws Exception {
        id++;
        Scanner snc = new Scanner(System.in);

        System.out.println("Event name: ");
        this.eventName = snc.nextLine();

        System.out.println("Event location: ");
        this.eventLocation = snc.nextLine();

        System.out.println("Event Date: ");
        this.eventDate = snc.nextLine();

        System.out.println("1 - Chess \n2 - Tennis \n3 Basketball \n4 Soccer : ");
        this.eventSport = snc.nextInt();

        System.out.println("Event Prize: ");
        this.eventPrize = snc.nextInt();

        setEventId();
        setOrganizingCost();
        getInfo();


    }

    private void setEventId(){
        id++;
        this.eventId = eventSport +  1000 + id;
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

    public String getInfo() {
        switch (eventSport) {
            case 0:
                return eventName + " is an Sport event , starting at " + eventDate + " at " + eventLocation;
            case 1:
                return eventName + " is an Chess event , starting at " + eventDate + " at " + eventLocation;

            case 2:
                return eventName + " is an Tennis event , starting at " + eventDate + " at " + eventLocation;

            case 3:
                return eventName + " is an Basketball event , starting at " + eventDate + " at " + eventLocation;

            case 4:
                return eventName + " is an Soccer event , starting at " + eventDate + " at " + eventLocation;
            default:
                return "There s no information about this event";
        }
    }


}


