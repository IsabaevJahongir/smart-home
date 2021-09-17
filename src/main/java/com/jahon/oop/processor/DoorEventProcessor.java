package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.SmartHome;

import static com.jahon.oop.SensorEventType.DOOR_CLOSED;
import static com.jahon.oop.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    // событие от двери
    public void process(SmartHome smartHome, SensorEvent event) {
        SensorEventType eventType = event.getType();
        if (isDoorEvent(eventType)) {
            smartHome.executeAction((obj) -> {
                if (obj instanceof Door) {
                    Door door = (Door) obj;
                    if (door.getId().equals(event.getObjectId())) {
                        door.setOpen(isDoorOpen(eventType));
                    }
                }
            });
        }
    }

    private boolean isDoorEvent(SensorEventType eventType) {
        return eventType == DOOR_OPEN || eventType == DOOR_CLOSED;
    }

    private boolean isDoorOpen(SensorEventType eventType) {
        return eventType == SensorEventType.DOOR_OPEN;
    }
}