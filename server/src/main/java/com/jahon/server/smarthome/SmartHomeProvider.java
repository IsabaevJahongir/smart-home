package com.jahon.server.smarthome;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jahon.server.smarthome.item.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmartHomeProvider {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static SmartHome getSmartHome() throws IOException {
        // считываем состояние дома из файла
        String json = new String(Files.readAllBytes(Paths.get(SmartHomeProvider.class.getClassLoader().getResource("smarthome.js").getFile())));

        SmartHome smartHome = mapper.readValue(json, SmartHome.class);

        return smartHome;
    }

}
