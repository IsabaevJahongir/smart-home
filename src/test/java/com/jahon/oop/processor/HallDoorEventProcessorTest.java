package com.jahon.oop.processor;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;
import com.jahon.oop.SmartHomeProvider;
import com.jahon.oop.item.Door;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class HallDoorEventProcessorTest {

    private SmartHome smartHome;

    @Before
    public void init() throws IOException {
        smartHome = SmartHomeProvider.getSmartHome();
    }


    @Test
    public void processHallDoorCloseTest() {
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "4");

        new HallDoorEventProcessor().process(smartHome, event);

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }

}
