package com.jahon.oop.processor;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.item.SmartHome;

public interface EventProcessor {

    void process(SmartHome smartHome, SensorEvent event);

}
