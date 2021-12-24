package com.jahon.application;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomePrinter {
    public static final String HOME_FILE_PATH = "smarthomes/smarthome2.js";

    public static void printHome() throws IOException {
        String home = new String(Files.readAllBytes(Paths.get(App.class.getClassLoader().getResource(HOME_FILE_PATH).getFile())), StandardCharsets.UTF_8);

        System.out.println(home);
    }


}
