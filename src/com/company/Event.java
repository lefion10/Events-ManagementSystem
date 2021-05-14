package com.company;

public class Event {
    private String eventName ;
    private String eventLocation ;
    private String eventDate;
    private int eventPrize;
    private String eventDescription;
    private int eventBudget;
    private int organizingCost = 1000;

    public Event(){
        Scanner snc = new Scanner(System.in);
        System.out.println("Event name: ");
        this.eventName = snc.nextLine();
        System.out.println("Event location: ");
        this.eventLocation = snc.nextLine();
        System.out.println("Event Date: ");
        this.eventDate = snc.nextLine();
        System.out.println("Event Prize: ");
        this.eventPrize = snc.nextInt();
        System.out.println("Event Description: ");
        this.eventDescription = snc.nextLine();
        System.out.println(eventDescription);
    }
}
