package com.jahon.home.smarthome;

import com.jahon.home.smarthome.item.alarm.AlarmActivatedState;
import com.jahon.home.smarthome.item.alarm.AlarmAlertState;
import com.jahon.home.smarthome.item.alarm.AlarmDeactivatedState;
import com.jahon.home.smarthome.item.alarm.AlarmState;

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
