package com.jahon.oop;

import com.jahon.oop.processor.DoorEventProcessor;
import com.jahon.oop.processor.HallDoorEventProcessor;
import com.jahon.oop.processor.LightEventProcessor;

public class EventManagerFactory {

    public static EventManager createEventManager() {
        EventManager eventManager = new EventManager();
        eventManager.addEventProcessor(new DoorEventProcessor());
        eventManager.addEventProcessor(new HallDoorEventProcessor());
        eventManager.addEventProcessor(new LightEventProcessor());

        return eventManager;
    }

}
