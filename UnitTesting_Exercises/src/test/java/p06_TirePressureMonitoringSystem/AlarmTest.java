package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setAlarm() {
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmWithLowerPressure() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.2);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHigherPressure() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.9);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithNormalPressure() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.1);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}