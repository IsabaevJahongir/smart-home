package com.jahon.oop.item;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;

import java.util.Collection;

import static com.jahon.oop.SensorEventType.*;

public class Room implements ItemEventExecutor {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    @Override
    public void execute(SensorEvent sensorEvent) {
        SensorEventType eventType = sensorEvent.getType();

        if (eventType == DOOR_OPEN || eventType == DOOR_CLOSED) {
            for (Door door : doors) {
                door.execute(sensorEvent);
            }
        } else if (eventType == LIGHT_ON || eventType == LIGHT_OFF) {
            for (Light light : lights) {
                light.execute(sensorEvent);
            }
        }
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "lights=" + lights +
                ", doors=" + doors +
                ", name='" + name + '\'' +
                "}\n";
    }
}
