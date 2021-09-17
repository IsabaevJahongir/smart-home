package com.jahon.oop.item;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;

public class Door implements ItemEventExecutor {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
    public void execute(SensorEvent event) {
        if (id.equals(event.getObjectId())) {
            if (event.getType() == SensorEventType.DOOR_OPEN) {
                setOpen(true);
                System.out.println("Door " + getId() + " was opened.");
            } else {
                setOpen(false);
                System.out.println("Door " + getId() + " was closed.");
            }
        }
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id='" + id + '\'' +
                ", isOpen=" + isOpen +
                "}\n";
    }

}
