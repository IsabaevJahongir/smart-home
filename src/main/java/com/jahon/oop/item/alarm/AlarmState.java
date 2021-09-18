package com.jahon.oop.item.alarm;

import static com.jahon.oop.AlarmStateType.ALERT;

public interface AlarmState {
    void activate(Alarm alarm, String password);

    void deactivate(Alarm alarm, String password);

    default void alert(Alarm alarm, String password){
        System.out.println("Alert! Alert! Alert!");
        alarm.changeState(ALERT.getState());
    }
}
