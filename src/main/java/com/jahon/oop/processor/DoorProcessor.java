package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

public class DoorProcessor {

    public static void process(SmartHome smartHome, SensorEvent event) {
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == SensorEventType.DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                    }
                }
            }
        }
    }




}
