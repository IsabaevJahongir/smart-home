package com.jahon.oop;

import com.jahon.oop.remote.RemoteControl;


public class RemoteCommandExecutor {

    public void executCommand(String buttonCode, String rcId) {
        RemoteControl remote = RemoteControlRegistry.getRemote(rcId);
        remote.onButtonPressed(buttonCode);
    }

}
