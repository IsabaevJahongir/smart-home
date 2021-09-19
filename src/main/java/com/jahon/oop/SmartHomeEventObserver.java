package com.jahon.oop;

import com.jahon.oop.eventprovider.EventProvider;
import com.jahon.oop.eventprovider.RandomEventProvider;
import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;

import static com.jahon.oop.ItemType.*;


public class SmartHomeEventObserver {
    private static final Logger log = LoggerFactory.getLogger(SmartHomeEventObserver.class);

    private final EnumMap<ItemType, EventProcessor> eventProcessors = new EnumMap<>(ItemType.class);

    {
        subscribeEventProcessor(DOOR, new DoorEventProcessor());
        subscribeEventProcessor(HALL_DOOR, new HallDoorEventProcessor());
        subscribeEventProcessor(LIGHT, new LightEventProcessor());
        subscribeEventProcessor(ALARM, new AlarmEventProcessor());
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
            log.info("Got event: " + event);

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
