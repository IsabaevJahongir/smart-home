package com.jahon.oop.remote.command;

import com.jahon.oop.item.SmartHome;
import com.jahon.oop.item.alarm.Alarm;

public class AlarmAlertCommand implements Command {
    private final SmartHome smartHome;

    public AlarmAlertCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void executeCommand() {
        smartHome.executeAction(obj -> {
            if (obj instanceof Alarm) {
                Alarm alarm = (Alarm) obj;
                alarm.getAlarmState().alert(alarm, "qwerty");
            }
        });
    }


}
