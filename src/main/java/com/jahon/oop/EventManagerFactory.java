package com.jahon.oop;

import com.jahon.oop.processor.*;

import static com.jahon.oop.item.ItemType.*;

public class EventManagerFactory {

    public static EventManager createEventManager() {
        EventManager eventManager = new EventManager();
        eventManager.subscribeEventProcessor(DOOR, new DoorEventProcessor());
        eventManager.subscribeEventProcessor(HALL_DOOR, new HallDoorEventProcessor());
        eventManager.subscribeEventProcessor(LIGHT, new LightEventProcessor());

        return eventManager;
    }

}
