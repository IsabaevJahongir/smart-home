package com.jahon.home.smarthome.eventprovider;

import com.jahon.home.smarthome.SensorEvent;

public interface EventProvider {
    SensorEvent getNextSensorEvent();
}
