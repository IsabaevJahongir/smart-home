package com.jahon.oop.util;

import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

public class ItemFinder {

    public static Door findDoorById(SmartHome smartHome, String id) {

        Door foundDoor = null;

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id)) {
                    return door;
                }
            }
        }

        return foundDoor;
    }


    public static Light findLightById(SmartHome smartHome, String id) {

        Light foundLight = null;

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id)) {
                    return light;
                }
            }
        }

        return foundLight;
    }


}
