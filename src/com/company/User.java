package com.company;
import java.util.Scanner;
import java.util.ArrayList;

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
        this.events = snc.nextInt();

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
                balance -= 100;
            }
            else{
             break;
            }
        }while(true);
    }
    


}
