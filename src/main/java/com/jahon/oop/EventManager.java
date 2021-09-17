package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

public class EventManager {
    private EventObserver eventObserver;
    private SmartHome smartHome;

    public EventManager(SmartHome smartHome, EventObserver eventObserver) {
        this.eventObserver = eventObserver;
        this.smartHome = smartHome;
    }

    public void run() {
        SensorEvent event = EventProvider.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);

            eventObserver.processEvent(smartHome, event);

            event = EventProvider.getNextSensorEvent();
        }
    }

}
