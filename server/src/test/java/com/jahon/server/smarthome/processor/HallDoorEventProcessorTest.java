package com.jahon.server.smarthome.processor;

import com.jahon.server.smarthome.SensorEvent;
import com.jahon.server.smarthome.SensorEventType;
import com.jahon.server.smarthome.SmartHomeProvider;
import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.Room;
import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.processor.HallDoorEventProcessor;
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
