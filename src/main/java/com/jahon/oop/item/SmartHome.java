package com.jahon.oop.item;

import com.jahon.oop.SensorEvent;


import java.util.ArrayList;
import java.util.Collection;


public class SmartHome implements ItemEventExecutor {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute(SensorEvent sensorEvent) {
        for (Room room : rooms) {
            room.execute(sensorEvent);
        }

    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "SmartHome{" +
                "rooms=" + rooms +
                '}';
    }
}
