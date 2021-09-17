package com.jahon.oop;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.DoorEventProcessor;
import com.jahon.oop.processor.EventProcessor;
import com.jahon.oop.processor.HallDoorEventProcessor;
import com.jahon.oop.processor.LightEventProcessor;

import java.util.EnumMap;

import static com.jahon.oop.ItemType.*;


public class SmartHomeEventObserver {

    private SmartHome smartHome;

    public SmartHomeEventObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private final EnumMap<ItemType, EventProcessor> eventProcessors = new EnumMap<>(ItemType.class);

    {
        subscribeEventProcessor(DOOR, new DoorEventProcessor());
        subscribeEventProcessor(HALL_DOOR, new HallDoorEventProcessor());
        subscribeEventProcessor(LIGHT, new LightEventProcessor());
    }

    public void processEvent(SensorEvent event) {
        for (EventProcessor eventProcessor : eventProcessors.values()) {
            eventProcessor.process(smartHome, event);
        }
    }

    public void run() {
        SensorEvent event = RandomEventProvider.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);

            processEvent(event);

            event = RandomEventProvider.getNextSensorEvent();
        }
    }


    private void subscribeEventProcessor(ItemType itemType, EventProcessor eventProcessor) {
        eventProcessors.put(itemType, eventProcessor);
    }

    private void unsubscribeEventProcessor(ItemType itemType) {
        eventProcessors.remove(itemType);
    }

}
