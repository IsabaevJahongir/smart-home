package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

public class HallDoorEventProcessor implements EventProcessor {

    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public void process(SmartHome smartHome, SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_OPEN || event.getType() == SensorEventType.DOOR_CLOSED) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (room.getName().equals("hall") && door.getId().equals(event.getObjectId()) && event.getType() == SensorEventType.DOOR_CLOSED) {
                        turnOffAllLights(smartHome);
                    }
                }
            }
        }
    }

    private void turnOffAllLights(SmartHome smartHome) {
        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                sendCommand(command);
            }
        }
    }

    private void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}

