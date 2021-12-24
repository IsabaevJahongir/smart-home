package com.jahon.application.menu;

import com.jahon.application.App;
import com.jahon.application.UI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainMenu implements Menu {
    private static final String TEXT_PATH = "main_menu.txt";

    @Override
    public void show(UI ui) {
        System.out.println("=============== Main menu ===============");
        try {
            String mainMenuText = new String(Files.readAllBytes(Paths.get(App.class.getClassLoader().getResource(TEXT_PATH).getFile())), StandardCharsets.UTF_8);
            System.out.println(mainMenuText);
            String num = br.readLine();

            switch (num) {
                case "1":
                    ui.setMenu(new RegistrationMenu());
                    break;
                case "2":
                    ui.setMenu(new LoginMenu());
                    break;
                case "3":
                    System.exit(0);
                default:
                    ui.setMenu(new MainMenu());
                    break;
            }
        } catch (IOException ex) {
            System.out.println("File problem: \n" + ex);
        }
    }
}







