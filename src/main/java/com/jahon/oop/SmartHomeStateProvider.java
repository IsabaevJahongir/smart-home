package com.jahon.oop;

import com.google.gson.Gson;
import com.jahon.oop.item.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeStateProvider {

    public static SmartHome getSmartHomeState() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);

        return smartHome;
    }

}
