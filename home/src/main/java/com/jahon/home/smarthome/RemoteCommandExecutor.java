package com.jahon.home.smarthome;

import com.jahon.home.smarthome.item.remote.RemoteControl;


public class RemoteCommandExecutor {

    public void executCommand(String buttonCode, String rcId) {
        RemoteControl remote = RemoteControlRegistry.getRemote(rcId);
        remote.onButtonPressed(buttonCode);
    }

}
