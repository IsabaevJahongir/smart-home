package com.jahon.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jahon.application.ApplicationGlobalState;
import org.springframework.http.HttpEntity;

public class UserHomeRest extends Rest {

    private final String REGISTER_HOME_URL = "http://localhost:8000/userhome";

    public void registerHome(String smartHome) throws JsonProcessingException {
        headers.add("Authorization", ApplicationGlobalState.getInstance().getCurrentSession().getToken().getAccess());

        System.out.println(smartHome);
        HttpEntity<String> request = new HttpEntity<>(smartHome, headers);

        String response = restTemplate.postForObject(REGISTER_HOME_URL, request, String.class);

        System.out.println(response);
    }


}
