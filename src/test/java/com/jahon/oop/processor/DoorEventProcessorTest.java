package com.jahon.oop.processor;

import java.io.IOException;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;
import com.jahon.oop.SmartHomeProvider;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;
import org.junit.Before;
import org.junit.Test;

import static com.jahon.oop.util.ItemFinder.findDoorById;
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
