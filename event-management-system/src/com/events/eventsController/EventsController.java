package com.events.eventsController;

import com.events.eventsService.EventsService;
import com.events.pojos.Event;


import java.awt.*;
import java.io.PrintStream;
import java.util.Scanner;

public class EventsController {
    private EventsService eventsService;
    public EventsController(EventsService eventsService){
        this.eventsService=eventsService;
    }

    public void start(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("\n----Event ManagementSystem-----");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    userMenu(scanner);
                    break;
                case  3:
                    System.out.println("Existing System GoodBye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice , Try Again");

            }
        }

    }

    public void adminMenu(Scanner scanner){
        while (true){
            System.out.println("\n----Welcome Admin-----");
            System.out.println("1. Add Event");
            System.out.println("2. View Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Update event");
            System.out.println("5. Log Out");
            System.out.println("Enter Your Choice");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Event Id: ");
                    String Id=scanner.nextLine();
                    System.out.println("Enter Event Name: ");
                    String name=scanner.nextLine();
                    System.out.println("Enter Event Date (DD/MM/YY): ");
                    String date=scanner.nextLine();
                    System.out.println("Enter Available Seats :");
                    int seats= scanner.nextInt();
                    scanner.nextLine();

                    if(eventsService.addEvent(new Event(Id,name,date,seats))){
                        System.out.println("Event Added Successfully");
                    }
                    else{
                        System.out.println("Failed to add Event ,storage is Full");
                    }
                    break;
                case 2:
                    Event[] events= eventsService.getAllEvent();
                    if(events.length==0){
                        System.out.println(" No Event found");
                    }
                    else{
                        for(Event event:events){
                            System.out.println(event);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter Event Id to delete");
                    String eventId= scanner.next();
                    if(eventsService.deleteEvent(eventId)){
                        System.out.println("Event deleted successfully");
                    }
                    else{
                        System.out.println("Event not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Event Id: ");
                    String newId= scanner.nextLine();
                    System.out.println("Enter Event Name: ");
                    String newName= scanner.nextLine();
                    System.out.println("Enter Event Date (DD/MM/YY): ");
                    String newDate= scanner.nextLine();
                    System.out.println("Enter Event Seats");
                    int newSeats= scanner.nextInt();

                    if(eventsService.updateEvent(new Event(newId,newName,newDate,newSeats))!=null){
                        System.out.println("Event Updated Successfully");
                    }
                    else {
                        System.out.println("Event is not updated, Event Id is not found");
                    }
                    break;
                case 5:
                    System.out.println("Logging Out from Admin Menu");
                    return;
                default:
                    System.out.println("Envalid Choice Try Again");

            }
        }
    }

    public void userMenu(Scanner scanner){
        while (true) {
            System.out.println("\n----Welcome User----");
            System.out.println("1. View events");
            System.out.println("2. Register For Event");
            System.out.println("3. LogOut ");
            System.out.println("Enter Your Choice: ");
            int choice= scanner.nextInt();

            switch (choice){
                case 1:
                    Event[] events= eventsService.getAllEvent();
                    if(events.length==0){
                        System.out.println("Event is not found");
                    }
                    else {
                        for (Event event:events){
                            System.out.println(event);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Event Id to register");
                    String eventId= scanner.next();
                    System.out.println(eventsService.registerForEvent(eventId));
                    break;
                case 3:
                    System.out.println("Logging Out From User Menu");
                    return;
                default:
                    System.out.println("Invalid Choice ,Try Again");

            }

        }
    }

}
