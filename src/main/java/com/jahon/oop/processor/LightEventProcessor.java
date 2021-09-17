package com.jahon.oop.processor;


import com.jahon.oop.*;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.SmartHome;

import static com.jahon.oop.SensorEventType.LIGHT_OFF;
import static com.jahon.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {


    public void process(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        if(isLightEvent(event.getType())) {
            smartHome.executeAction(obj -> {
                if (obj instanceof Light) {
                    Light light = (Light) obj;
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == SensorEventType.LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " was turned on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " was turned off.");
                        }
                    }
                }
            });
        }
    }


    private boolean isLightEvent(SensorEventType eventType) {
        return eventType == LIGHT_ON || eventType == LIGHT_OFF;
    }

}
