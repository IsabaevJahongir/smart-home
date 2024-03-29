package com.jahon.server.smarthome.processor;

import com.jahon.server.smarthome.util.ItemFinder;
import com.jahon.server.smarthome.SensorEvent;
import com.jahon.server.smarthome.SensorEventType;
import com.jahon.server.smarthome.SmartHomeProvider;
import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.SmartHome;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

        Light light = ItemFinder.findLightById(smartHome, event.getObjectId());
        new LightEventProcessor().process(smartHome, event);

        assertTrue(light.isOn());
    }


    @Test
    public void processLightOfTest() {
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "1");

        Light light = ItemFinder.findLightById(smartHome, event.getObjectId());
        new LightEventProcessor().process(smartHome, event);

        assertFalse(light.isOn());
    }


}
