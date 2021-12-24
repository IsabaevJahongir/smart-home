package com.jahon.home.processor;

import com.jahon.home.smarthome.SensorEvent;
import com.jahon.home.smarthome.SensorEventType;
import com.jahon.home.smarthome.SmartHomeProvider;
import com.jahon.home.smarthome.item.SmartHome;
import com.jahon.home.smarthome.item.alarm.Alarm;
import com.jahon.home.smarthome.item.alarm.AlarmActivatedState;
import com.jahon.home.smarthome.item.alarm.AlarmAlertState;
import com.jahon.home.smarthome.item.alarm.AlarmDeactivatedState;
import com.jahon.home.smarthome.processor.AlarmEventProcessor;
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
