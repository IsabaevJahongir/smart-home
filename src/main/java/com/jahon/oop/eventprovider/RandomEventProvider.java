package com.jahon.oop.eventprovider;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;

import static com.jahon.oop.SensorEventType.ALARM_ACTIVATE;
import static com.jahon.oop.SensorEventType.ALARM_DEACTIVATE;

public class RandomEventProvider implements EventProvider {

    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        if (sensorEventType == ALARM_ACTIVATE || sensorEventType == ALARM_DEACTIVATE) {
            objectId = "1";
        }

        return new SensorEvent(sensorEventType, objectId);
    }

}
