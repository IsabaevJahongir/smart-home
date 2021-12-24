package com.jahon.application.menu;

import com.jahon.application.App;
import com.jahon.application.UI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserMenu implements Menu {
    public static final String TEXT_PATH = "user_menu.txt";

    @Override
    public void show(UI ui) {
        System.out.println("=============== User menu ===============");
        try {
            String mainMenuText = new String(Files.readAllBytes(Paths.get(App.class.getClassLoader().getResource(TEXT_PATH).getFile())));
            System.out.println(mainMenuText);

            String num = br.readLine();
            switch (num) {
                case "1":
                    ui.setMenu(new ViewHomeMenu());
                    break;
                case "2":
                    ui.setMenu(new CommandMenu());
                    break;
                case "3":
                    ui.setMenu(new RefreshTokenMenu());
                    break;
                case "4":
                    ui.setMenu(new MainMenu());
                    break;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
