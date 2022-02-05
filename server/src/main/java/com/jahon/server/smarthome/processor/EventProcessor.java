package com.jahon.server.smarthome.processor;

import com.jahon.server.smarthome.SensorEvent;
import com.jahon.server.smarthome.item.SmartHome;

public interface EventProcessor {

    void process(SmartHome smartHome, SensorEvent event);

}
