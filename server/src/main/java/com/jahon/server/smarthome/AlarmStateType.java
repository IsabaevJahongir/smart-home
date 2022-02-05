package com.jahon.server.smarthome;

import com.jahon.server.smarthome.item.alarm.AlarmActivatedState;
import com.jahon.server.smarthome.item.alarm.AlarmAlertState;
import com.jahon.server.smarthome.item.alarm.AlarmDeactivatedState;
import com.jahon.server.smarthome.item.alarm.AlarmState;

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
