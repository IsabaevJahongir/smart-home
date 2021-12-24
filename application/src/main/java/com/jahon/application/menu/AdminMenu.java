package com.jahon.application.menu;

import com.jahon.application.App;
import com.jahon.application.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminMenu implements Menu {
    private static final String TEXT_PATH = "admin_menu.txt";

    @Override
    public void show(UI ui) {
        System.out.println("=============== Admin menu ===============");
        try {
            String adminMenuText = new String(Files.readAllBytes(Paths.get(App.class.getClassLoader().getResource(TEXT_PATH).getFile())));
            System.out.println(adminMenuText);

            String num = br.readLine();
            switch (num) {
                case "1":
                    ui.setMenu(new UserHomeRegisterMenu());
                    break;
                case "2":
                    ui.setMenu(new MainMenu());
                    break;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
