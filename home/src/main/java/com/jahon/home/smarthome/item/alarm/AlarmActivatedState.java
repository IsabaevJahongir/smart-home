package com.jahon.home.smarthome.item.alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jahon.home.smarthome.AlarmStateType.*;


public class AlarmActivatedState implements AlarmState {
    private static final Logger log = LoggerFactory.getLogger(AlarmActivatedState.class);

    @Override
    public void activate(Alarm alarm, String pass) {
        log.info("Alarm is already activate.");
        alert(alarm, "");
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            log.info("Alarm success deactivated!");
            alarm.changeState(DEACTIVATE.getState());
        } else {
            log.error("Wrong password for deactivate.");
            alert(alarm, "");
        }
    }

}
