package com.jahon.oop;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE("qwerty"), ALARM_DEACTIVATE("qwerty");

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
