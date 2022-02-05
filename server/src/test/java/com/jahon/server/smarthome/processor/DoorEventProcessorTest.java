package com.jahon.server.smarthome.processor;

import com.jahon.server.smarthome.SensorEvent;
import com.jahon.server.smarthome.SensorEventType;
import com.jahon.server.smarthome.SmartHomeProvider;
import com.jahon.server.smarthome.item.Door;
import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.util.ItemFinder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DoorEventProcessorTest {

    private SmartHome smartHome;


    @Before
    public void init() throws IOException {
        smartHome = SmartHomeProvider.getSmartHome();
    }


    @Test
    public void processDoorOpenTest() {
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        Door door = ItemFinder.findDoorById(smartHome, event.getObjectId());
        new DoorEventProcessor().process(smartHome, event);

        assertTrue(door.isOpen());
    }

    @Test
    public void processDoorClosedTest() {
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");
        Door door = ItemFinder.findDoorById(smartHome,event.getObjectId());
        new DoorEventProcessor().process(smartHome, event);

        assertFalse(door.isOpen());
    }



}
