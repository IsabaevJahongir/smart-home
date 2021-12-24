package com.jahon.application.rest;

import com.jahon.application.ApplicationGlobalState;
import com.jahon.application.model.Token;
import org.springframework.http.HttpEntity;

import java.io.IOException;

public class RefreshRest extends Rest {
    private static final String LOGIN_URL = "http://localhost:9000/refresh";


    public void refresh(String strToken) throws IOException {
        headers.add("refresh-token", strToken);

        HttpEntity<String> request = new HttpEntity<>("", headers);

        String response = restTemplate.postForObject(LOGIN_URL, request, String.class);

        Token newToken = objectMapper.readValue(response, Token.class);

        System.out.println("New token: " + newToken.getAccess());

        ApplicationGlobalState.getInstance().getCurrentSession().setToken(newToken);
    }

}
