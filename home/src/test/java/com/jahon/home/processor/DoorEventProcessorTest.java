package com.jahon.home.processor;

import com.jahon.home.smarthome.SensorEvent;
import com.jahon.home.smarthome.SensorEventType;
import com.jahon.home.smarthome.SmartHomeProvider;
import com.jahon.home.smarthome.item.Door;
import com.jahon.home.smarthome.item.SmartHome;
import com.jahon.home.smarthome.processor.DoorEventProcessor;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.jahon.home.util.ItemFinder.findDoorById;
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
        Door door = findDoorById(smartHome, event.getObjectId());
        new DoorEventProcessor().process(smartHome, event);

        assertTrue(door.isOpen());
    }

    @Test
    public void processDoorClosedTest() {
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");
        Door door = findDoorById(smartHome,event.getObjectId());
        new DoorEventProcessor().process(smartHome, event);

        assertFalse(door.isOpen());
    }



}
