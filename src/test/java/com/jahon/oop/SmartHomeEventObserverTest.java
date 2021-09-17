package com.jahon.oop;

import com.jahon.oop.eventprovider.EventProvider;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.SmartHome;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jahon.oop.SensorEventType.*;
import static com.jahon.oop.util.ItemFinder.findDoorById;
import static com.jahon.oop.util.ItemFinder.findLightById;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SmartHomeEventObserverTest {


    @Test
    public void runTest() throws IOException {
        EventProvider eventProvider = getEventProvider();
        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        SmartHomeEventObserver eventObserver = new SmartHomeEventObserver(smartHome, eventProvider);

        Door door1 = findDoorById(smartHome, "1");
        Door door2 = findDoorById(smartHome, "2");
        Light light1 = findLightById(smartHome, "1");
        Light light2 = findLightById(smartHome, "2");


        assertFalse(door1.isOpen());
        assertFalse(door2.isOpen());
        assertFalse(light1.isOn());
        assertTrue(light2.isOn());

        eventObserver.run();

        assertTrue(door1.isOpen());
        assertFalse(door2.isOpen());
        assertTrue(light1.isOn());
        assertTrue(light2.isOn());


    }


    private EventProvider getEventProvider() {
        return new EventProvider() {
            private final List<SensorEvent> sensorEvents = new ArrayList<>();

            {
                sensorEvents.add(new SensorEvent(LIGHT_ON, "1"));
                sensorEvents.add(new SensorEvent(DOOR_OPEN, "1"));
                sensorEvents.add(null);
            }

            @Override
            public SensorEvent getNextSensorEvent() {
                return sensorEvents.remove(0);
            }
        };
    }

}
