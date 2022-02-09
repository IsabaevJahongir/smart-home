package com.jahon.server.smarthome.item.alarm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jahon.server.smarthome.item.Action;
import com.jahon.server.smarthome.item.Actionable;

import static com.jahon.server.smarthome.AlarmStateType.DEACTIVATE;

@JsonIgnoreProperties(value = { "password" })
public class Alarm implements Actionable {

    private String id;
    private String password;
    private AlarmState state;

    public Alarm() {
    }

    public Alarm(String id) {
        this.id = id;
        this.password = "qwerty";
        this.state = DEACTIVATE.getState();
    }


    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    void changeState(AlarmState state) {
        this.state = state;
    }

    boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public AlarmState getAlarmState() {
        return state;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id='" + id + '\'' +
                '}';
    }
}
