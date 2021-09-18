package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.SmartHome;
import com.jahon.oop.item.alarm.Alarm;
import com.jahon.oop.item.alarm.AlarmDeactivatedState;

import static com.jahon.oop.SensorEventType.LIGHT_OFF;
import static com.jahon.oop.SensorEventType.LIGHT_ON;

public class LightEventProcessor implements EventProcessor {

    // событие от источника света
    public void process(SmartHome smartHome, SensorEvent event) {
        SensorEventType eventType = event.getType();
        Alarm alarm = smartHome.getAlarm();

        if (isLightEvent(eventType)) {
            if (alarm.getAlarmState() instanceof AlarmDeactivatedState) {
                smartHome.executeAction(obj -> {
                    if (obj instanceof Light) {
                        Light light = (Light) obj;
                        if (light.getId().equals(event.getObjectId())) {
                            light.setOn(isLightOn(eventType));
                        }
                    }
                });
            } else {
                alarm.getAlarmState().alert(alarm, "");
            }
        }
    }


    private boolean isLightEvent(SensorEventType eventType) {
        return eventType == LIGHT_ON || eventType == LIGHT_OFF;
    }

    private boolean isLightOn(SensorEventType eventType) {
        return eventType == LIGHT_ON;
    }
}
