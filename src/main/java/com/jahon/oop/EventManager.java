package com.jahon.oop;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.EventProcessor;

import java.util.ArrayList;
import java.util.List;


public class EventManager {
    private List<EventProcessor> eventProcessors = new ArrayList<>();

    public void addEventProcessor(EventProcessor eventProcessor){
        eventProcessors.add(eventProcessor);
    }

    public void processEvent(SmartHome smartHome, SensorEvent event){
        for(EventProcessor eventProcessor : eventProcessors){
            eventProcessor.process(smartHome, event);
        }
    }

}
