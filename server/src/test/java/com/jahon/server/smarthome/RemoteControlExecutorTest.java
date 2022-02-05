package com.jahon.server.smarthome;

import com.jahon.server.smarthome.util.ItemFinder;
import com.jahon.server.smarthome.item.Door;
import com.jahon.server.smarthome.item.Light;
import com.jahon.server.smarthome.item.Room;
import com.jahon.server.smarthome.item.SmartHome;
import com.jahon.server.smarthome.item.alarm.AlarmActivatedState;
import com.jahon.server.smarthome.item.alarm.AlarmAlertState;
import com.jahon.server.smarthome.item.alarm.AlarmDeactivatedState;
import com.jahon.server.smarthome.item.remote.MyRemoteControl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoteControlExecutorTest {

    private static SmartHome smartHome;
    private static final RemoteCommandExecutor rcExecutor = new RemoteCommandExecutor();

    @Before
    public void init() throws IOException {
        smartHome = SmartHomeProvider.getSmartHome();
        RemoteControlRegistry.registerRemoteControl(new MyRemoteControl(smartHome), "1");
    }

    /**
     * Команда "A" активирует сигнализацию
     */
    @Test
    public void executeCommandATest() throws IOException {
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmDeactivatedState);
        rcExecutor.executCommand("A", "1");
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmActivatedState);
    }

    /**
     * Команда "B" переводит сигнализацию в режим тревоги
     */
    @Test
    public void executeCommandBTest() {
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmDeactivatedState);
        rcExecutor.executCommand("B", "1");
        assertTrue(smartHome.getAlarm().getAlarmState() instanceof AlarmAlertState);
    }

    /**
     * Команда "C" выключает свет во всех комнатах
     */
    @Test
    public void executeCommandCTest() {
        System.out.println(smartHome);
        rcExecutor.executCommand("C", "1");

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }

    /**
     * Команда "D" включает свет во всех комнатах
     */
    @Test
    public void executeCommandDTest() {
        rcExecutor.executCommand("D", "1");

        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertTrue(light.isOn());
            }
        }
    }

    /**
     * Команда "1" закрывает дверь в коридоре
     */
    @Test
    public void executeCommand1Test() {
        Door hallDoor = ItemFinder.findDoorById(smartHome, "4");
        hallDoor.setOpen(true);
        rcExecutor.executCommand("1", "1");

        assertFalse(hallDoor.isOpen());
    }

    /**
     * Команда "1" закрывает дверь в коридоре
     */
    @Test
    public void executeCommand2Test() {
        rcExecutor.executCommand("2", "1");

        Room hall = ItemFinder.findRoomByName(smartHome, "hall");

        for(Light light: hall.getLights()){
            assertTrue(light.isOn());
        }
    }

}
