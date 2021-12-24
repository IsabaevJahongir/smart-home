package com.jahon.application.menu;

import com.jahon.application.UI;
import com.jahon.application.model.UserRegistration;
import com.jahon.application.rest.RegistrationRest;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public class RegistrationMenu implements Menu {

    @Override
    public void show(UI ui) {
        System.out.println("=============== Registration ===============");
        try {
            System.out.println("Enter login: ");
            String login = br.readLine();
            System.out.println("Enter password: ");
            String password = br.readLine();
            System.out.println("Enter first name: ");
            String firstName = br.readLine();
            System.out.println("Enter last name: ");
            String lastName = br.readLine();
            System.out.println("Enter email: ");
            String email = br.readLine();

            UserRegistration userCredential = new UserRegistration(login, password, firstName, lastName, email);

            boolean isRegister = new RegistrationRest().registrate(userCredential);

            if (isRegister) {
                ui.setMenu(new LoginMenu());
            } else {
                System.out.println("Failed to register. Change login and try again");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getMessage().substring(6) + ". Try again");
        }
    }
}
