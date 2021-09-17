package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        EventObserver eventHandler = new EventObserver();

        // начинаем цикл обработки событий
        new EventManager(smartHome, eventHandler).run();

    }

}
