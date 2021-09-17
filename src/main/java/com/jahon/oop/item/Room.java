package com.jahon.oop.item;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    @Override
    public void executeAction(Action action) {
        for (Light light : lights) {
            light.executeAction(action);
        }

        for (Door door : doors) {
            door.executeAction(action);
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
