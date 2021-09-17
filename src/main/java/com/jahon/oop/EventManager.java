package com.jahon.oop;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.EventProcessor;

import java.util.EnumMap;


public class EventManager {

    private EnumMap<ItemType, EventProcessor> eventProcessors = new EnumMap<>(ItemType.class);

    public void subscribeEventProcessor(ItemType itemType, EventProcessor eventProcessor) {
        eventProcessors.put(itemType, eventProcessor);
    }

    public void unsubscribeEventProcessor(ItemType itemType) {
        eventProcessors.remove(itemType);
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        for (EventProcessor eventProcessor : eventProcessors.values()) {
            eventProcessor.process(smartHome, event);
        }
    }

}
