package com.jahon.application.menu;

import com.jahon.application.ApplicationGlobalState;
import com.jahon.application.UI;
import com.jahon.application.rest.RefreshRest;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public class RefreshTokenMenu implements Menu {
    @Override
    public void show(UI ui) {
        try {
            new RefreshRest().refresh(ApplicationGlobalState.getInstance().getCurrentSession().getToken().getRefresh());
        } catch (IOException ex) {
            System.out.println("Can't refresh token try again");
        } catch (HttpClientErrorException ex) {
            System.out.println("Can't refresh token. Re-login please");
            ui.setMenu(new MainMenu());
            return;
        }
        ui.setMenu(new UserMenu());

    }
}
