package com.jahon.oop.item;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;

public class Light implements ItemEventExecutor {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void execute(SensorEvent sensorEvent) {
        if (id.equals(sensorEvent.getObjectId())) {
            if (sensorEvent.getType() == SensorEventType.LIGHT_ON) {
                setOn(true);
                System.out.println("Light " + getId() + " was turned on.");
            } else {
                setOn(false);
                System.out.println("Light " + getId() + " was turned off.");
            }
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Light{" +
                "isOn=" + isOn +
                ", id='" + id + '\'' +
                "}\n";
    }
}
