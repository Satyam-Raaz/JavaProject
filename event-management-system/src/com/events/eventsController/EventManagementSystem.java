package com.events.eventsController;

import com.events.EventsDAO.EventDAOImpl;
import com.events.EventsDAO.EventsDAO;
import com.events.eventsService.EventsService;
import com.events.eventsService.EventsServiceImpl;

public class EventManagementSystem {
    public static void main(String[] args) {
        EventsDAO dao=new EventDAOImpl(10);
        EventsService service=new EventsServiceImpl(dao);
        EventsController controller=new EventsController(service);

        controller.start();
    }


}
