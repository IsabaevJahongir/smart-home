package com.jahon.oop.item;

import com.jahon.oop.SensorCommandSender;
import com.jahon.oop.SensorCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jahon.oop.SensorEventType.DOOR_CLOSED;
import static com.jahon.oop.SensorEventType.DOOR_OPEN;

public class Door implements Actionable {
    private static final Logger log = LoggerFactory.getLogger(Door.class);

    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
        if (isOpen) {
            log.info("Door " + id + " was opened.");
            SensorCommandSender.sendCommand(new SensorCommand(DOOR_OPEN, id));
        } else {
            log.info("Door " + id + " was closed.");
            SensorCommandSender.sendCommand(new SensorCommand(DOOR_CLOSED, id));
        }

    }

    @Override
    public String toString() {
        return "Door{" +
                "id='" + id + '\'' +
                ", isOpen=" + isOpen +
                "}\n";
    }

}
