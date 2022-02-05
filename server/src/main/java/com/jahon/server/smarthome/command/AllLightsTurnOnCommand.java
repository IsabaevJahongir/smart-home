package com.jahon.server.smarthome.command;

import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.SmartHome;

public class AllLightsTurnOnCommand implements Command {
    private final SmartHome smartHome;

    public AllLightsTurnOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                if (!light.isOn()) {
                    light.setOn(true);
                }
            }
        });
    }

}
