package com.jahon.server.model;

public class Payload {
    private String sub;
    private String role;
    private long exp;
    private long iat;

    public Payload() {
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
                ", exp=" + exp +
                ", iat=" + iat +
                '}';
    }
}
