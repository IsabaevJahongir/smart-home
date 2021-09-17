package com.jahon.oop.item;


public class Light implements Actionable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Light{" +
                "isOn=" + isOn +
                ", id='" + id + '\'' +
                "}\n";
    }
}
