package com.jahon.oop.item.alarm;

import static com.jahon.oop.AlarmStateType.*;


public class AlarmActivatedState implements AlarmState {

    @Override
    public void activate(Alarm alarm, String pass) {
        System.out.println("Alarm is already activate.");
        alert(alarm, "");
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            System.out.println("Alarm success deactivated!");
            alarm.changeState(DEACTIVATE.getState());
        } else {
            System.out.println("Wrong password for deactivate.");
            alert(alarm, "");
        }
    }

}
