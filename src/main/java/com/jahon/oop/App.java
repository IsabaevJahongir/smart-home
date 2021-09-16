package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        EventManager eventManager = EventManagerFactory.createEventManager();

        // начинаем цикл обработки событий
        SensorEvent event = SensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            eventManager.processEvent(smartHome, event);

            event = SensorEventProvider.getNextSensorEvent();
        }
    }

}
