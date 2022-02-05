package com.jahon.server.smarthome.processor;

import com.jahon.server.smarthome.item.alarm.Alarm;
import com.jahon.server.smarthome.SensorEvent;
import com.jahon.server.smarthome.SensorEventType;
import com.jahon.server.smarthome.item.Door;
import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.item.alarm.AlarmDeactivatedState;

import static com.jahon.server.smarthome.SensorEventType.DOOR_CLOSED;
import static com.jahon.server.smarthome.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {

    // событие от двери
    public void process(SmartHome smartHome, SensorEvent event) {
        SensorEventType eventType = event.getType();
        Alarm alarm = smartHome.getAlarm();
        if (isDoorEvent(eventType)) {
            if (alarm.getAlarmState() instanceof AlarmDeactivatedState) {
                smartHome.executeAction((obj) -> {
                    if (obj instanceof Door) {
                        Door door = (Door) obj;
                        if (door.getId().equals(event.getObjectId())) {
                            door.setOpen(isDoorOpen(eventType));
                        }
                    }
                });
            } else {
                alarm.getAlarmState().alert(alarm, "");
            }
        }
    }


    private boolean isDoorEvent(SensorEventType eventType) {
        return eventType == DOOR_OPEN || eventType == DOOR_CLOSED;
    }

    private boolean isDoorOpen(SensorEventType eventType) {
        return eventType == SensorEventType.DOOR_OPEN;
    }
}