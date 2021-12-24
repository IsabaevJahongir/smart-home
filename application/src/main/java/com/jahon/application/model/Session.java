package com.jahon.application.model;

public class Session {
    private String login;
    private Token token;

    public Session(String login, Token token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Session{" +
                "login='" + login + '\'' +
                ", token=" + token +
                '}';
    }
}
