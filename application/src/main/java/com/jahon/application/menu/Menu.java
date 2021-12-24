package com.jahon.application.menu;

import com.jahon.application.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface Menu {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void show(UI ui);

}
