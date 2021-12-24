package com.jahon.application.rest;

import com.jahon.application.ApplicationGlobalState;
import com.jahon.application.model.Session;
import com.jahon.application.model.Token;
import com.jahon.application.model.UserLogin;
import org.springframework.http.HttpEntity;

import java.io.IOException;

public class LoginRest extends Rest {

    private static final String LOGIN_URL = "http://localhost:9000/login";

    public boolean login(UserLogin userLogin) throws IOException {
        String json = objectMapper.writeValueAsString(userLogin);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        String response = restTemplate.postForObject(LOGIN_URL, request, String.class);

        Token token = objectMapper.readValue(response, Token.class);
        System.out.println(token.getAccess());
        ApplicationGlobalState.getInstance().setCurrentSession(new Session(userLogin.getLogin(), token));

        return true;
    }

}
