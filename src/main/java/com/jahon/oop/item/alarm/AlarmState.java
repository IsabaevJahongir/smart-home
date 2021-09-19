package com.jahon.oop.item.alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jahon.oop.AlarmStateType.ALERT;

public interface AlarmState {
    Logger log = LoggerFactory.getLogger(AlarmState.class);

    void activate(Alarm alarm, String password);

    void deactivate(Alarm alarm, String password);

    default void alert(Alarm alarm, String password) {
        log.info("Alert! Alert! Alert!");
        alarm.changeState(ALERT.getState());
    }
}
