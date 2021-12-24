package com.jahon.home.smarthome.item.alarm;

import com.jahon.home.smarthome.AlarmStateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface AlarmState {
    Logger log = LoggerFactory.getLogger(AlarmState.class);

    void activate(Alarm alarm, String password);

    void deactivate(Alarm alarm, String password);

    default void alert(Alarm alarm, String password) {
        log.info("Alert! Alert! Alert!");
        alarm.changeState(AlarmStateType.ALERT.getState());
    }
}
