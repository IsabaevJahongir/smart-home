package com.jahon.application.menu;

import com.jahon.application.ApplicationGlobalState;
import com.jahon.application.Decoder;
import com.jahon.application.UI;
import com.jahon.application.model.UserLogin;
import com.jahon.application.rest.LoginRest;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public class LoginMenu implements Menu {
    private static int incorrectTryNumber = 0;

    @Override
    public void show(UI ui) {
        System.out.println("=============== Login ===============");
        try {
            System.out.println("Enter login: ");
            String login = br.readLine();
            System.out.println("Enter password: ");
            String password = br.readLine();

            UserLogin userLogin = new UserLogin(login, password);

            boolean isLogged = new LoginRest().login(userLogin);

            if (isLogged) {
                String accessToken = ApplicationGlobalState.getInstance().getCurrentSession().getToken().getAccess();
                String role = Decoder.getPayload(accessToken).getRole();
                switch (role) {
                    case "admin":
                        ui.setMenu(new AdminMenu());
                        break;
                    case "user":
                        ui.setMenu(new UserMenu());
                        break;
                }
            } else {
                System.out.println("Not logged in. Try again");
                incorrectTryNumber++;
                if (incorrectTryNumber >= 3) {
                    System.out.println("Input limit exceeded");
                    ui.setMenu(new MainMenu());
                }
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getMessage().substring(6) + ". Try again");
            if (incorrectTryNumber >= 3) {
                incorrectTryNumber++;
                System.out.println("Input limit exceeded");
                ui.setMenu(new MainMenu());
            }
        }

    }
}
