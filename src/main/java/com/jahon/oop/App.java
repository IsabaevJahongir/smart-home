package com.jahon.oop;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.processor.DoorProcessor;
import com.jahon.oop.processor.HallDoorProcessor;
import com.jahon.oop.processor.LightProcessor;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeStateProvider.getSmartHomeState();

        // начинаем цикл обработки событий
        SensorEvent event = SensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == SensorEventType.LIGHT_ON || event.getType() == SensorEventType.LIGHT_OFF) {
                LightProcessor.process(smartHome, event);
            }
            if (event.getType() == SensorEventType.DOOR_OPEN || event.getType() == SensorEventType.DOOR_CLOSED) {
                DoorProcessor.process(smartHome, event);
                HallDoorProcessor.process(smartHome, event);
            }
            event = SensorEventProvider.getNextSensorEvent();
        }
    }

}
