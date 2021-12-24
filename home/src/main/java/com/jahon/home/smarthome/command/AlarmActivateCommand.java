package com.jahon.home.smarthome.command;

import com.jahon.home.smarthome.item.SmartHome;
import com.jahon.home.smarthome.item.alarm.Alarm;

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
                alarm.getAlarmState().activate(alarm, System.getProperty("activate"));
            }
        });
    }
}
