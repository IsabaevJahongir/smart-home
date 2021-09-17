package com.jahon.oop.processor;


import com.jahon.oop.*;
import com.jahon.oop.item.SmartHome;

public class LightEventProcessor implements EventProcessor {

    public void process(SmartHome smartHome, SensorEvent event) {
        // событие от источника света
        smartHome.execute(event);
    }

}
