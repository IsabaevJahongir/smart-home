package com.jahon.home.smarthome;

public enum SensorEventType {
    LIGHT_ON, LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE(System.getProperty("activate", "default_password")), ALARM_DEACTIVATE(System.getProperty("deactivate", "default_deactivate"));

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
