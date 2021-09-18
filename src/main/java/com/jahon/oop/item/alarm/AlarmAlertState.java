package com.jahon.oop.item.alarm;

import static com.jahon.oop.AlarmStateType.*;

public class AlarmAlertState implements AlarmState {

    @Override
    public void activate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            System.out.println("Alert deactivate. Alarm activated");
            alarm.changeState(ACTIVATE.getState());
        } else {
            alert(alarm, pass);
        }
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            System.out.println("Alert deacivate. Alarm deactivated");
            alarm.changeState(DEACTIVATE.getState());
        } else {
            alert(alarm, pass);
        }
    }

}
