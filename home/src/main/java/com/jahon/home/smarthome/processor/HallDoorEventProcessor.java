package com.jahon.home.smarthome.processor;

import com.jahon.home.smarthome.item.alarm.Alarm;
import com.jahon.home.smarthome.SensorEvent;
import com.jahon.home.smarthome.SensorEventType;
import com.jahon.home.smarthome.item.Door;
import com.jahon.home.smarthome.item.Light;
import com.jahon.home.smarthome.item.Room;
import com.jahon.home.smarthome.item.SmartHome;
import com.jahon.home.smarthome.item.alarm.AlarmDeactivatedState;

import static com.jahon.home.smarthome.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {

    private static final String hallRoomName = "hall";

    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
    public void process(SmartHome smartHome, SensorEvent event) {
        if (isDoorCloseEvent(event.getType())) {
            Alarm alarm = smartHome.getAlarm();
            if (alarm.getAlarmState() instanceof AlarmDeactivatedState) {
                smartHome.executeAction(obj -> {
                    if (obj instanceof Room) {
                        Room hallRoom = (Room) obj;
                        if (hallRoom.getName().equals(hallRoomName)) {
                            for (Door door : hallRoom.getDoors()) {
                                if (door.getId().equals(event.getObjectId())) {
                                    door.setOpen(false);
                                    turnOffAllLights(smartHome);
                                    return;
                                }
                            }
                        }
                    }
                });
            } else {
                alarm.getAlarmState().alert(alarm, "");
            }
        }
    }

    private void turnOffAllLights(SmartHome smartHome) {
        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                light.setOn(false);
            }
        });
    }

    private boolean isDoorCloseEvent(SensorEventType eventType) {
        return eventType == DOOR_CLOSED;
    }

}

