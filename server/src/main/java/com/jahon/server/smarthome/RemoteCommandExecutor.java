package com.jahon.server.smarthome;

import com.jahon.server.smarthome.item.remote.RemoteControl;


public class RemoteCommandExecutor {

    public void executCommand(String buttonCode, String rcId) {
        RemoteControl remote = RemoteControlRegistry.getRemote(rcId);
        remote.onButtonPressed(buttonCode);
    }

}
