package com.jahon.server.smarthome;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE(System.getProperty("activate", "qwerty")), ALARM_DEACTIVATE(System.getProperty("deactivate", "qwerty"));

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
