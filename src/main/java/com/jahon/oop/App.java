package com.jahon.oop;

import com.jahon.oop.eventprovider.EventProvider;
import com.jahon.oop.eventprovider.RandomEventProvider;
import com.jahon.oop.item.SmartHome;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        EventProvider eventProvider = new RandomEventProvider();
        SmartHomeEventObserver eventObserver = new SmartHomeEventObserver(smartHome, eventProvider);

        // начинаем цикл обработки событий
        eventObserver.run();

    }

}
