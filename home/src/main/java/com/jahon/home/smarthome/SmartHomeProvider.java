package com.jahon.home.smarthome;

import com.google.gson.Gson;
import com.jahon.home.smarthome.item.SmartHome;
import com.jahon.home.smarthome.item.alarm.Alarm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeProvider {

    public static SmartHome getSmartHome() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();

        String json = new String(Files.readAllBytes(Paths.get(SmartHomeProvider.class.getClassLoader().getResource("smarthome.js").getFile())));
        //  String json = new String(Files.readAllBytes(Paths.get("server/smarthome.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);

        smartHome.setAlarm(new Alarm(smartHome.getAlarm().getId()));

        return smartHome;
    }

}
