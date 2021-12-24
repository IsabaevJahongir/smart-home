package com.jahon.application.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jahon.application.ApplicationGlobalState;
import com.jahon.application.model.UserHome;
import org.springframework.http.HttpEntity;

public class UserHomeRest extends Rest {

    private final String REGISTER_HOME_URL = "http://localhost:8000/userhome";

    public void registerHome(UserHome userHome) throws JsonProcessingException {

        String toSend = objectMapper.writeValueAsString(userHome);

        headers.add("Authorization", ApplicationGlobalState.getInstance().getCurrentSession().getToken().getAccess());

        HttpEntity<String> request = new HttpEntity<>(toSend, headers);

        String response = restTemplate.postForObject(REGISTER_HOME_URL, request, String.class);

        System.out.println(response);
    }


}
