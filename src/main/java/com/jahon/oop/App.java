package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        EventManager eventHandler = new EventManager();

        // начинаем цикл обработки событий
        new EventHandler(smartHome, eventHandler).run();

    }

}
