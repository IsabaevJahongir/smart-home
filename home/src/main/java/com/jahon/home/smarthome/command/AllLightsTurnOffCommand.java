package com.jahon.home.smarthome.command;

import com.jahon.home.smarthome.item.Light;
import com.jahon.home.smarthome.item.SmartHome;

public class AllLightsTurnOffCommand implements Command {
    private final SmartHome smartHome;

    public AllLightsTurnOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Light) {
                Light light = (Light) obj;
                if (light.isOn()) {
                    light.setOn(false);
                }
            }
        });
    }
}
