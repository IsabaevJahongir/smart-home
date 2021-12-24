package com.jahon.home.smarthome;

import com.jahon.home.smarthome.processor.*;
import com.jahon.home.smarthome.eventprovider.EventProvider;
import com.jahon.home.smarthome.item.SmartHome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;

import static com.jahon.home.smarthome.ItemType.*;


public class SmartHomeEventObserver {
    private static final Logger log = LoggerFactory.getLogger(SmartHomeEventObserver.class);

    private final EnumMap<ItemType, EventProcessor> eventProcessors = new EnumMap<>(ItemType.class);

    {
        subscribeEventProcessor(DOOR, new DoorEventProcessor());
        subscribeEventProcessor(HALL_DOOR, new HallDoorEventProcessor());
        subscribeEventProcessor(LIGHT, new LightEventProcessor());
        subscribeEventProcessor(ALARM, new AlarmEventProcessor());
    }

    private final SmartHome smartHome;
    private final EventProvider eventProvider;

    public SmartHomeEventObserver(SmartHome smartHome, EventProvider eventProvider) {
        this.smartHome = smartHome;
        this.eventProvider = eventProvider;
    }

    public void run() {
        SensorEvent event = eventProvider.getNextSensorEvent();

        while (event != null) {
            log.debug("Got event: " + event);

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
