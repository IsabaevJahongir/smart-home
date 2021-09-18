package com.jahon.oop.processor;

import com.jahon.oop.SensorEvent;
import com.jahon.oop.SensorEventType;
import com.jahon.oop.SmartHomeProvider;
import com.jahon.oop.item.SmartHome;
import com.jahon.oop.item.alarm.Alarm;
import com.jahon.oop.item.alarm.AlarmActivatedState;
import com.jahon.oop.item.alarm.AlarmAlertState;
import com.jahon.oop.item.alarm.AlarmDeactivatedState;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AlarmEventProcessorTest {


    @Test
    public void processTest() throws IOException {
        SmartHome smartHome = SmartHomeProvider.getSmartHome();
        Alarm alarm = smartHome.getAlarm();

        assertTrue(alarm.getAlarmState() instanceof AlarmDeactivatedState);

        SensorEvent sensorEvent1 = new SensorEvent(SensorEventType.ALARM_ACTIVATE, "1");
        AlarmEventProcessor alarmEventProcessor = new AlarmEventProcessor();
        alarmEventProcessor.process(smartHome, sensorEvent1);

        assertTrue(alarm.getAlarmState() instanceof AlarmActivatedState);

        SensorEvent sensorEvent2 = new SensorEvent(SensorEventType.ALARM_ACTIVATE, "1");
        alarmEventProcessor.process(smartHome, sensorEvent2);

        assertTrue(alarm.getAlarmState() instanceof AlarmAlertState);

    }

}
