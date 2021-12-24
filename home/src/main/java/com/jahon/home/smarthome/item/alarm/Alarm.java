package com.jahon.home.smarthome.item.alarm;

import com.jahon.home.smarthome.item.Action;
import com.jahon.home.smarthome.item.Actionable;

import static com.jahon.home.smarthome.AlarmStateType.DEACTIVATE;

public class Alarm implements Actionable {

    private final String id;
    private final transient String password;
    private transient AlarmState state;

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
