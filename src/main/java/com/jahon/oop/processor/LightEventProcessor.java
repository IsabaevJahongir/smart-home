package com.jahon.oop.processor;


import com.jahon.oop.*;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

public class LightEventProcessor implements EventProcessor {

    public void process(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        if (event.getType() == SensorEventType.LIGHT_ON || event.getType() == SensorEventType.LIGHT_OFF) {
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == SensorEventType.LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }

}
