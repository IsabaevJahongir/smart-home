package com.jahon.application;

import com.jahon.application.menu.MainMenu;

public class App {

    public static void main(String[] args) {
        System.out.println("Start application");
        UI ui = new UI();
        ui.setMenu(new MainMenu());
        ui.runMenu();
        System.out.println("End application");
    }

}
