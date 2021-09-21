package com.jahon.oop.remote;


import com.jahon.oop.item.SmartHome;
import com.jahon.oop.remote.command.*;

import java.util.HashMap;
import java.util.Map;

public class MyRemoteControl implements RemoteControl {
    private static final Map<String, Command> button = new HashMap<>();

    private final SmartHome smartHome;

    public MyRemoteControl(SmartHome smartHome) {
        this.smartHome = smartHome;
        initButtonCommand();
    }


    @Override
    public void onButtonPressed(String buttonCode) {
        button.get(buttonCode).executeCommand();
    }

    private void initButtonCommand() {
        button.put("A", new AlarmActivateCommand(smartHome));
        button.put("B", new AlarmAlertCommand(smartHome));
        button.put("C", new AllLightsTurnOffCommand(smartHome));
        button.put("D", new AllLightsTurnOnCommand(smartHome));
        button.put("1", new HallDoorCloseCommand(smartHome));
        button.put("2", new HallLightsOnCommand(smartHome));
    }

}
