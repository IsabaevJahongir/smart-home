package com.jahon.server.smarthome;

import com.jahon.server.smarthome.item.remote.RemoteControl;

import java.util.HashMap;
import java.util.Map;

public class RemoteControlRegistry{
    private static final Map<String, RemoteControl> remotes = new HashMap<>();

    public static void registerRemoteControl(RemoteControl remoteControl, String rcId) {
        remotes.put(rcId, remoteControl);
    }

    public static RemoteControl getRemote(String rcId){
        return remotes.get(rcId);
    }
}
