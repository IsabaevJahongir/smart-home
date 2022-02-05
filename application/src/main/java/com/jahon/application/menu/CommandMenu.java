package com.jahon.application.menu;

import com.jahon.application.UI;

public class CommandMenu implements Menu {

    @Override
    public void show(UI ui) {
        System.out.println("=============== Send command ===============");
        System.out.println("!!!! Pretent to send command !!!!");
        ui.setMenu(new UserMenu());
    }
}
