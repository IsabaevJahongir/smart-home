package com.jahon.server.smarthome.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jahon.server.smarthome.SensorCommandSender;
import com.jahon.server.smarthome.SensorCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jahon.server.smarthome.SensorEventType.LIGHT_OFF;
import static com.jahon.server.smarthome.SensorEventType.LIGHT_ON;

public class Light implements Actionable {
    private static final Logger log = LoggerFactory.getLogger(Light.class);

    @JsonProperty("on")
    private boolean isOn;
    private String id;

    public Light() {
    }

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
            log.info("Light " + id + " was turned on.");
            SensorCommandSender.sendCommand(new SensorCommand(LIGHT_ON, id));
        } else {
            log.info("Light " + id + " was turned off.");
            SensorCommandSender.sendCommand(new SensorCommand(LIGHT_OFF, id));
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
