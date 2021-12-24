package com.jahon.auth.model;

public class Token {

    private String access;
    private String refresh;

    public Token(String access, String refresh) {
        this.access = access;
        this.refresh = refresh;
    }

    public Token() {
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access='" + access + '\'' +
                ", refresh='" + refresh + '\'' +
                '}';
    }
}
