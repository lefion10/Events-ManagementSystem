package com.company;
import java.util.*;


public class User {
    private String firstName;
    private String lastName;
    private String schEvents;
    private int events ;
    private int balance = 0;

    private static int id = 1000;
    private int userId = 0;
    private ArrayList<String> ongoingEvents;

    {
        ongoingEvents = new ArrayList<String>();
    }

    public User(){
        id++;

        Scanner snc = new Scanner(System.in);

        System.out.println("Enter user first name: ");
        this.firstName = snc.nextLine();

        System.out.println("Enter user last name: ");
        this.lastName = snc.nextLine();

        System.out.println("1 - Chess \n2 - Tennis \n3 Basketball \n4 Soccer : ");
        try{
            do{
                this.events = snc.nextInt();
                if(events > 0 && events < 5){
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

        setUserId();
        eventEnroll();

    }

    private void setUserId(){
        this.userId = events + id;
        System.out.println("The Id of this User is: " + userId );
    }

    public void eventEnroll(){
        do{
            Scanner snc = new Scanner(System.in);
            System.out.println("Provide the event name to enroll or type Quit to finish enrolling: ");
            String event = snc.nextLine();
            if(!"Quit".equals(event)){
                ongoingEvents.add(event);
                if(balance < 0){
                    System.out.println("Your account balance has fallen below zero , you can't enroll in further events");
                    break;
                }
                balance -= 100;
            }
            else{
             break;
            }
        }while(true);

        System.out.println(firstName + " " + lastName + " will be attending to the following events: ");
        System.out.println(ongoingEvents);

    }

    public void balanceInfo(){
        System.out.println("Your balance is: " + balance + "$");
        if(balance < 0){
            System.out.println("Your account balance has fallen below zero!");
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
        if (!(obj instanceof User))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((User) obj).getId();
    }



}
