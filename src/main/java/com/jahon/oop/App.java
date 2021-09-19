package com.jahon.oop;

import com.jahon.oop.eventprovider.EventProvider;
import com.jahon.oop.eventprovider.RandomEventProvider;
import com.jahon.oop.item.SmartHome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {
        log.info("Start Smarthome");

        try {
            SmartHome smartHome = SmartHomeProvider.getSmartHome();
            EventProvider eventProvider = new RandomEventProvider();
            SmartHomeEventObserver eventObserver = new SmartHomeEventObserver(smartHome, eventProvider);

            // начинаем цикл обработки событий
            eventObserver.run();
        } catch (IOException ex) {
            log.error("Problem with the smarthome init file");
        }


        log.info("End Smarthome");
    }

}
