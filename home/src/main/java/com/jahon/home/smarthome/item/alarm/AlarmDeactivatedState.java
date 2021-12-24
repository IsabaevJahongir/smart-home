package com.jahon.home.smarthome.item.alarm;

import com.jahon.home.smarthome.AlarmStateType;

public class AlarmDeactivatedState implements AlarmState {

    @Override
    public void activate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            System.out.println("Alarm activate!");
            alarm.changeState(AlarmStateType.ACTIVATE.getState());
        } else {
            System.out.println("Wrong password. Try again!");
        }
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        System.out.println("Alarm is already deactivate!");
    }
}
