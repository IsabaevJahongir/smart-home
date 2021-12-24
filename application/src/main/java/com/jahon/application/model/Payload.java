package com.jahon.application.model;

public class Payload {
    private String sub;
    private String role;
    private String iss;
    private String login;
    private long exp;
    private long iat;

    public Payload() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "sub='" + sub + '\'' +
                ", role='" + role + '\'' +
                ", iss='" + iss + '\'' +
                ", login='" + login + '\'' +
                ", exp=" + exp +
                ", iat=" + iat +
                '}';
    }
}
