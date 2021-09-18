package com.jahon.oop;

import com.jahon.oop.item.alarm.AlarmActivatedState;
import com.jahon.oop.item.alarm.AlarmAlertState;
import com.jahon.oop.item.alarm.AlarmDeactivatedState;
import com.jahon.oop.item.alarm.AlarmState;

public enum AlarmStateType {
    ACTIVATE("activate", new AlarmActivatedState()), DEACTIVATE("deactivate", new AlarmDeactivatedState()), ALERT("alert", new AlarmAlertState());

    AlarmStateType(String name, AlarmState alarmState) {
        this.name = name;
        this.alarmState = alarmState;
    }

    String name;
    AlarmState alarmState;

    public AlarmState getState() {
        return alarmState;
    }

}
