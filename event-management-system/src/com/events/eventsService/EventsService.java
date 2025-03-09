package com.events.eventsService;

import com.events.pojos.Event;

public interface EventsService {
    boolean addEvent(Event event);
    Event[] getAllEvent();
    boolean deleteEvent(String eventId);
    Event getEventById(String eventId);
    Event updateEvent(Event newEvent);
    String registerForEvent(String eventId);
}
