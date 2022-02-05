package com.jahon.server.smarthome.command;

import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.item.alarm.Alarm;

public class AlarmActivateCommand implements Command {
    private final SmartHome smartHome;

    public AlarmActivateCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Alarm) {
                Alarm alarm = (Alarm) obj;
                alarm.getAlarmState().activate(alarm, "qwerty");
            }
        });
    }
}
