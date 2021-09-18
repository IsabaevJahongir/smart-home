package com.jahon.oop;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE("111"), ALARM_DEACTIVATE("222"), ALARM_ALERT_OFF("333");

    SensorEventType() {
    }

    SensorEventType(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }
}
