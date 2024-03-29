package com.jahon.server.smarthome.util;

import com.jahon.server.smarthome.item.Door;
import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.Room;
import com.jahon.server.smarthome.item.SmartHome;

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

    public static Room findRoomByName(SmartHome smartHome, String name) {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

}
