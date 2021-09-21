package com.jahon.oop.remote.command;

import com.jahon.oop.item.Light;
import com.jahon.oop.item.Room;
import com.jahon.oop.item.SmartHome;

import java.awt.*;

public class HallLightsOnCommand implements Command {
    private final String HALL = "hall";

    private final SmartHome smartHome;

    public HallLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Room) {
                Room room = (Room) obj;
                if (room.getName().equals(HALL)) {
                    for (Light light : room.getLights()) {
                        if (!light.isOn()) {
                            light.setOn(true);
                        }
                    }
                }

            }
        });
    }
}
