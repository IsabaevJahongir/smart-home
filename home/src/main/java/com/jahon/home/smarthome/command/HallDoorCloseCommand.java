package com.jahon.home.smarthome.command;

import com.jahon.home.smarthome.item.Door;
import com.jahon.home.smarthome.item.Room;
import com.jahon.home.smarthome.item.SmartHome;

public class HallDoorCloseCommand implements Command {

    public static final String HALL = "hall";

    private final SmartHome smartHome;

    public HallDoorCloseCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Room) {

                Room room = (Room) obj;

                if (room.getName().equals(HALL)) {
                    for (Door door : room.getDoors()) {
                        if (door.isOpen()) {
                            door.setOpen(false);
                        }
                    }
                }

            }
        });
    }
}
