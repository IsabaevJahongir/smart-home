package com.jahon.oop.item;

import java.util.ArrayList;
import java.util.Collection;


public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void executeAction(Action action) {
        for (Room room : rooms) {
            room.executeAction(action);
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
