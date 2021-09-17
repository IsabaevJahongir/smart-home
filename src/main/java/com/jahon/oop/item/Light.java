package com.jahon.oop.item;

import com.jahon.oop.CommandSender;
import com.jahon.oop.SensorCommand;

import static com.jahon.oop.SensorEventType.LIGHT_OFF;
import static com.jahon.oop.SensorEventType.LIGHT_ON;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
        if (on) {
            System.out.println("Light " + id + " was turned on.");
            CommandSender.sendCommand(new SensorCommand(LIGHT_ON, id));
        } else {
            System.out.println("Light " + id + " was turned off.");
            CommandSender.sendCommand(new SensorCommand(LIGHT_OFF, id));
        }
    }

    @Override
    public String toString() {
        return "Light{" +
                "isOn=" + isOn +
                ", id='" + id + '\'' +
                "}\n";
    }
}
