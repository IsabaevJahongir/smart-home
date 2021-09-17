package com.jahon.oop.processor;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;
import com.jahon.oop.SmartHomeProvider;
import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.jahon.oop.util.ItemFinder.findLightById;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LightEventProcessorTest {

    private SmartHome smartHome;

    @Before
    public void init() throws IOException {
        smartHome = SmartHomeProvider.getSmartHome();
    }


    @Test
    public void processLightOnTest() {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "4");

        Light light = findLightById(smartHome, event.getObjectId());
        new LightEventProcessor().process(smartHome, event);

        assertTrue(light.isOn());
    }


    @Test
    public void processLightOfTest() {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "1");

        Light light = findLightById(smartHome, event.getObjectId());
        new LightEventProcessor().process(smartHome, event);

        assertFalse(light.isOn());
    }


}
