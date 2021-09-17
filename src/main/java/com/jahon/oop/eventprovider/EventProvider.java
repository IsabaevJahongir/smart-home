package com.jahon.oop.eventprovider;

import com.jahon.oop.SensorEvent;

public interface EventProvider {
    SensorEvent getNextSensorEvent();
}
