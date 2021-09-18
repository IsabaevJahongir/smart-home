package com.jahon.oop.item.alarm;

import com.jahon.oop.item.Action;

public class Alarm implements Action {

    private String id;
    private String password;
    private AlarmState state;


    @Override
    public void execute(Object obj) {

    }

    void changeState(AlarmState state) {
        this.state = state;
    }

    boolean checkPassword(String password) {
        return this.password.equals(password);
    }

}
