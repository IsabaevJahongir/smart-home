package com.jahon.oop.item.alarm;

import static com.jahon.oop.AlarmStateType.*;

public class AlarmDeactivatedState implements AlarmState {

    @Override
    public void activate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            System.out.println("Alarm activate!");
            alarm.changeState(ACTIVATE.getState());
        } else {
            System.out.println("Wrong password. Try again!");
        }
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        System.out.println("Alarm is already deactivate!");
    }
}
