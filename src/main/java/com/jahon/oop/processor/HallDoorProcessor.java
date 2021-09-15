package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

public class HallDoorProcessor {

    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public static void process(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (room.getName().equals("hall") && door.getId().equals(event.getObjectId()) && event.getType() == SensorEventType.DOOR_CLOSED) {
                    turnOffAllLights(smartHome);
                }
            }
        }
    }

    private static void turnOffAllLights(SmartHome smartHome) {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                sendCommand(command);
            }
        }
    }

    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}

