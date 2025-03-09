package com.events.eventsService;

import com.events.EventsDAO.EventsDAO;
import com.events.eventExceptions.EventsFullException;
import com.events.pojos.Event;

public class EventsServiceImpl implements EventsService{

    private EventsDAO eventsDAO;
    public EventsServiceImpl(EventsDAO eventsDAO){
        this.eventsDAO=eventsDAO;
    }
    @Override
    public  boolean addEvent(Event event){
        boolean res=eventsDAO.addEvent(event);
        if(res==false){
            throw new EventsFullException("no more events accepted");
        }
        return res;
    }

    @Override
    public Event[] getAllEvent(){
        return eventsDAO.getAllEvents();
    }

    @Override
    public boolean deleteEvent(String eventId){
        return eventsDAO.deleteEvent(eventId);
    }

    @Override
    public Event getEventById(String eventId){
        return eventsDAO.getEventById(eventId);
    }
    @Override

    public Event updateEvent(Event newEvent){
        return  eventsDAO.updateEvent(newEvent);
    }

    @Override
    public String registerForEvent(String eventId){
        Event event=eventsDAO.getEventById(eventId);
        if(event==null){
            return "event not found";
        }
        if(event.getAvailableSeats()<=0){
            return "No seats available";
        }
        event.setAvailableSeats(event.getAvailableSeats()-1);
        return "Successfully registered";
    }
}
