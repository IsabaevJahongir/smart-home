package com.jahon.oop.item.alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jahon.oop.AlarmStateType.*;

public class AlarmAlertState implements AlarmState {
    private static final Logger log = LoggerFactory.getLogger(AlarmAlertState.class);

    @Override
    public void activate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            log.info("Alert deactivate. Alarm activated");
            alarm.changeState(ACTIVATE.getState());
        } else {
            alert(alarm, pass);
        }
    }

    @Override
    public void deactivate(Alarm alarm, String pass) {
        if (alarm.checkPassword(pass)) {
            log.info("Alert deacivate. Alarm deactivated");
            alarm.changeState(DEACTIVATE.getState());
        } else {
            alert(alarm, pass);
        }
    }

}
