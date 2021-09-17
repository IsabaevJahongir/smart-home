package com.jahon.oop.processor;

import com.jahon.oop.*;
import com.jahon.oop.item.SmartHome;

public class DoorEventProcessor implements EventProcessor {

    public void process(SmartHome smartHome, SensorEvent event) {
        smartHome.execute(event);
    }

}
