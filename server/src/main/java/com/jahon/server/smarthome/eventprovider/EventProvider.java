package com.jahon.server.smarthome.eventprovider;

import com.jahon.server.smarthome.SensorEvent;

public interface EventProvider {
    SensorEvent getNextSensorEvent();
}
