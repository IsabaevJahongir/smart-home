package com.jahon.home.smarthome.processor;

import com.jahon.home.smarthome.SensorEvent;
import com.jahon.home.smarthome.item.SmartHome;

public interface EventProcessor {

    void process(SmartHome smartHome, SensorEvent event);

}
