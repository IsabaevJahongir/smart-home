package com.jahon.oop;

import com.jahon.oop.eventprovider.EventProvider;
import com.jahon.oop.eventprovider.RandomEventProvider;
import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.DoorEventProcessor;
import com.jahon.oop.processor.EventProcessor;
import com.jahon.oop.processor.HallDoorEventProcessor;
import com.jahon.oop.processor.LightEventProcessor;

import java.util.EnumMap;

import static com.jahon.oop.ItemType.*;


public class SmartHomeEventObserver {

    private final EnumMap<ItemType, EventProcessor> eventProcessors = new EnumMap<>(ItemType.class);

    {
        subscribeEventProcessor(DOOR, new DoorEventProcessor());
        subscribeEventProcessor(HALL_DOOR, new HallDoorEventProcessor());
        subscribeEventProcessor(LIGHT, new LightEventProcessor());
    }

    private SmartHome smartHome;
    private EventProvider eventProvider;

    public SmartHomeEventObserver(SmartHome smartHome, EventProvider eventProvider) {
        this.smartHome = smartHome;
        this.eventProvider = eventProvider;
    }


    public void run() {
        SensorEvent event = eventProvider.getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);

            processEvent(event);

            event = eventProvider.getNextSensorEvent();
        }
    }


    private void processEvent(SensorEvent event) {
        for (EventProcessor eventProcessor : eventProcessors.values()) {
            eventProcessor.process(smartHome, event);
        }
    }

    private void subscribeEventProcessor(ItemType itemType, EventProcessor eventProcessor) {
        eventProcessors.put(itemType, eventProcessor);
    }

    private void unsubscribeEventProcessor(ItemType itemType) {
        eventProcessors.remove(itemType);
    }

}