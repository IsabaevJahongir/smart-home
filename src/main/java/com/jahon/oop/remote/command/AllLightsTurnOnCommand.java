package com.jahon.oop.remote.command;

import com.jahon.oop.item.Light;
import com.jahon.oop.item.SmartHome;

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
