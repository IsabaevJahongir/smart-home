package com.jahon.server.smarthome.item;

import com.jahon.server.smarthome.item.alarm.Alarm;

import java.util.Collection;

public class SmartHome implements Actionable {
    private final Collection<Room> rooms;
    private Alarm alarm;

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.rooms = rooms;
        this.alarm = alarm;
    }

    @Override
    public void executeAction(Action action) {
        alarm.executeAction(action);

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

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "SmartHome{" +
                "rooms=" + rooms +
                ", alarm=" + alarm +
                '}';
    }
}
