package com.jahon.oop.processor;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;
import com.jahon.oop.item.SmartHome;
import com.jahon.oop.item.alarm.Alarm;


import static com.jahon.oop.SensorEventType.*;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void process(SmartHome smartHome, SensorEvent event) {
        SensorEventType eventType = event.getType();

        if (isAlarmEvent(eventType)) {
            smartHome.executeAction(obj -> {
                if (obj instanceof Alarm) {
                    Alarm alarm = (Alarm) obj;
                    if (alarm.getId().equals(event.getObjectId())) {
                        switch (eventType) {
                            case ALARM_ACTIVATE:
                                alarm.getAlarmState().activate(alarm, eventType.getCode());
                                break;
                            case ALARM_DEACTIVATE:
                                alarm.getAlarmState().deactivate(alarm, eventType.getCode());
                                break;
                        }
                    }
                }
            });

        }
    }

    private boolean isAlarmEvent(SensorEventType eventType) {
        return eventType == ALARM_ACTIVATE || eventType == ALARM_DEACTIVATE;
    }
}
