package com.jahon.server.smarthome.command;

import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.Room;
import com.jahon.server.smarthome.item.SmartHome;

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
