package com.jahon.application.rest;

import com.jahon.application.model.UserRegistration;
import org.springframework.http.HttpEntity;

import java.io.IOException;

public class RegistrationRest extends Rest {

    private static final String REGISTRATION_URL = "http://localhost:9000/register";

    public boolean registrate(UserRegistration userCredential) throws IOException {

        String json = objectMapper.writeValueAsString(userCredential);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        String response = restTemplate.postForObject(REGISTRATION_URL, request, String.class);

        System.out.println(response);

        return true;
    }


}
