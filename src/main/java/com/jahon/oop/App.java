package com.jahon.oop;

import com.jahon.oop.item.SmartHome;

import java.io.IOException;

public class App {

    public static void main(String... args) throws IOException {

        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        SmartHomeEventObserver eventObserver = new SmartHomeEventObserver(smartHome);

        // начинаем цикл обработки событий
        eventObserver.run();

    }

}
