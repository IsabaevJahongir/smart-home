package com.jahon.application.menu;

import com.jahon.application.HomePrinter;
import com.jahon.application.UI;

import java.io.IOException;

public class ViewHomeMenu implements Menu {
    @Override
    public void show(UI ui) {
        System.out.println("===============  Show home ===============");
        try {
            HomePrinter.printHome();
            ui.setMenu(new UserMenu());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
