package com.jahon.oop.remote.command;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.item.alarm.Alarm;

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
