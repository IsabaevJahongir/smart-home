package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

public class EventHandler {
    private EventManager eventManager;
    private SmartHome smartHome;

    public EventHandler(SmartHome smartHome, EventManager eventManager) {
        this.eventManager = eventManager;
        this.smartHome = smartHome;
    }

    public void run() {
        SensorEvent event = EventProvider.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);

            eventManager.handle(smartHome, event);

            event = EventProvider.getNextSensorEvent();
        }
    }

}
