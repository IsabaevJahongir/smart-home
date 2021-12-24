package com.jahon.application.model;

public class UserHome {
    private String json;
    private String username;

    public UserHome(String json, String username) {
        this.json = json;
        this.username = username;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "HomeRegistration{" +
                "json='" + json + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
