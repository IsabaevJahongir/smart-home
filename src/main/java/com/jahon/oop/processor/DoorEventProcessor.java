package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.SmartHome;

import static com.jahon.oop.SensorEventType.DOOR_CLOSED;
import static com.jahon.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    public void process(SmartHome smartHome, SensorEvent event) {
        if(isDoorEvent(event.getType())) {
            smartHome.executeAction((obj) -> {
                if (obj instanceof Door) {
                    Door door = (Door) obj;
                    if (door.getId().equals(event.getObjectId())) {
                        if (event.getType() == SensorEventType.DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " was closed.");
                        }
                    }
                }
            });
        }
    }

    private boolean isDoorEvent(SensorEventType eventType) {
        return eventType == DOOR_OPEN || eventType == DOOR_CLOSED;
    }
}