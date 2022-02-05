package com.jahon.server.smarthome;

import com.jahon.server.smarthome.eventprovider.EventProvider;
import com.jahon.server.smarthome.eventprovider.RandomEventProvider;
import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.item.remote.MyRemoteControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        log.info("Start Smarthome");

        try {
            SmartHome smartHome = SmartHomeProvider.getSmartHome();
            RemoteControlRegistry.registerRemoteControl(new MyRemoteControl(smartHome), "1");
            EventProvider eventProvider = new RandomEventProvider();
            SmartHomeEventObserver eventObserver = new SmartHomeEventObserver(smartHome, eventProvider);

            // начинаем цикл обработки событий
            eventObserver.run();
        } catch (IOException ex) {
            log.error("Problem with the smarthome init file: ", ex);
        }


        log.info("End Smarthome");
    }

}
