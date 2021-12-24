package com.jahon.application.menu;

import com.jahon.application.App;
import com.jahon.application.UI;
import com.jahon.application.model.UserHome;
import com.jahon.application.rest.UserHomeRest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserHomeRegisterMenu implements Menu {

    @Override
    public void show(UI ui) {
        try {
            System.out.println("Enter file name (@see resources/smarthomes):");
            String smPath = br.readLine();
            smPath = "smarthomes/" + smPath;
            String smJson = new String(Files.readAllBytes(Paths.get(App.class.getClassLoader().getResource(smPath).getFile())), StandardCharsets.UTF_8);

            System.out.println("Enter username for home owner:");
            String username = br.readLine();

            UserHome userHome = new UserHome(smJson, username);

            new UserHomeRest().registerHome(userHome);

            ui.setMenu(new AdminMenu());


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
