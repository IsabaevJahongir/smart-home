package com.jahon.application;

import com.jahon.application.menu.Menu;

public class UI {
    private Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void runMenu() {
        while (true) {
            menu.show(this);
        }
    }

}
