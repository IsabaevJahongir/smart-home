package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

import static com.jahon.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {

    private static final String hallRoomName = "hall";

    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public void process(SmartHome smartHome, SensorEvent event) {
        if (isDoorClosed(event.getType())) {
            smartHome.executeAction(obj -> {
                if (obj instanceof Room) {
                    Room hallRoom = (Room) obj;
                    if (hallRoom.getName().equals(hallRoomName)) {
                        for (Door door : hallRoom.getDoors()) {
                            if (door.getId().equals(event.getObjectId())) {
                                turnOffAllLights(smartHome);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }


    private void turnOffAllLights(SmartHome smartHome) {

        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.setOn(false);
                System.out.println("Light " + light.getId() + " was turned on.");
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                sendCommand(command);
            }
        });
    }

    private void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private boolean isDoorClosed(SensorEventType eventType) {
        return eventType == DOOR_CLOSED;
    }

}

