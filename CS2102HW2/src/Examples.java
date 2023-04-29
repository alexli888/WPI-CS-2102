
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
public class Examples {
    @Test
    public void testEquals() {
        SnowReading r1 = new SnowReading(10, 5);
        SnowReading r2 = new SnowReading(10, 5);
        SnowReading r3 = new SnowReading(5, 10);
        SnowReading r4 = new SnowReading(10, -999);

        assertTrue(r1.equals(r2));
        assertFalse(r1.equals(r3));
        assertFalse(r1.equals(r4));
    }

    @Test
    public void test_snowreading_nothingAndAllInvalidNums(){
        SnowReading r5 = new SnowReading();
        SnowReading r6 = new SnowReading(-999,-999);
        assertEquals(r5,r6);
    }

    @Test
    public void test_snowreading_allnegNums(){
        SnowReading r1 = new SnowReading(-8,-1);
        SnowReading r2 = new SnowReading(-10,-2);
        assertFalse(r1.equals(r2));
    }
    @Test
    public void test_snowreading_AllZeros(){
        SnowReading r420 = new SnowReading(0,0);
        SnowReading r69 = new SnowReading(0,0);
        assertEquals(r420,r69);
    }

    @Test
    public void testToString() {
        SnowReading r1 = new SnowReading(13, 3);
        SnowReading r2 = new SnowReading(-999, 5);
        SnowReading r3 = new SnowReading(15, -999);

        assertEquals("13C:3cm", r1.toString());
        assertEquals("Err:5cm", r2.toString());
        assertEquals("15C:Err", r3.toString());
    }

    @Test
    public void testsnowreading_string1(){
        SnowReading r1 = new SnowReading();
        assertEquals("Err:Err",r1.toString());
    }

    @Test
    public void testsnowreading_string2(){
        SnowReading r1 = new SnowReading(-999,5);
        assertEquals("Err:5cm",r1.toString());
    }

    @Test
    public void testNoArgConstructor() {
        SnowReading r = new SnowReading();

        assertEquals(-999, (int) r.tempC);
        assertEquals(-999, (int) r.cm);
    }

    @Test
    public void testReadSensorData2() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-5, 10));
        readings.add(new SnowReading(-10, 20));
        readings.add(new SnowReading(-15, 30));
        station.readSensorData(readings);
        LinkedList<SensorReading> currentData = station.getCurrentSensorData();
        assertEquals(3, currentData.size());
        assertEquals(-5, (int) currentData.get(0).tempC);
        assertEquals(10, (int) currentData.get(0).cm);
        assertEquals(-10, (int) currentData.get(1).tempC);
        assertEquals(20, (int) currentData.get(1).cm);
        assertEquals(-15, (int) currentData.get(2).tempC);
        assertEquals(30, (int) currentData.get(2).cm);
    }
    @Test
    public void testGetCurrentSensorDataOnAMixOfPostiveAndNegativeNumbersForEachSnowReading() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        LinkedList<SensorReading> currentData = station.getCurrentSensorData();
        assertEquals(0, currentData.size());
        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-5, 10));
        readings.add(new SnowReading(-10, 20));
        readings.add(new SnowReading(-15, 30));
        station.readSensorData(readings);
        currentData = station.getCurrentSensorData();
        assertEquals(3, currentData.size());
        assertEquals(-5, (int) currentData.get(0).tempC);
        assertEquals(10, (int) currentData.get(0).cm);
        assertEquals(-10, (int) currentData.get(1).tempC);
        assertEquals(20, (int) currentData.get(1).cm);
        assertEquals(-15, (int) currentData.get(2).tempC);
        assertEquals(30, (int) currentData.get(2).cm);
    }
    @Test
    public void testMedianReading2() {
        SnowStationSimpleIn station = new SnowStationSimpleIn();
        SensorReading median = station.medianReading();
        assertEquals(-999, (int) median.tempC);
        assertEquals(-999, (int) median.cm);

        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-5, 10));
        readings.add(new SnowReading(-10, 20));
        readings.add(new SnowReading(-15, 30));
        readings.add(new SnowReading(-20, 40));
        readings.add(new SnowReading(-25, 50));
        station.readSensorData(readings);

        median = station.medianReading();
        assertEquals(-15, (int) median.tempC);
        assertEquals(30, (int) median.cm);

        readings.add(new SnowReading(-30, 60));
        readings.add(new SnowReading(-35, -999));
        readings.add(new SnowReading(-40, -999));
        readings.add(new SnowReading(-45, -999));
        readings.add(new SnowReading(-50, -999));
        station.readSensorData(readings);

        median = station.medianReading();
        assertEquals(-20, (int) median.tempC);
        assertEquals(30, (int) median.cm);
    }
    @Test
    public void testReadSensorData() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-5, 10));
        readings.add(new SnowReading(-3, 8));
        readings.add(new SnowReading(-7, 11));
        station.readSensorData(readings);
        LinkedList<SensorReading> currentData = station.getCurrentSensorData();
        assertEquals(3, currentData.size());
        assertEquals(-5, (int) currentData.get(0).tempC);
        assertEquals(10, (int) currentData.get(0).cm);
        assertEquals(-3, (int) currentData.get(1).tempC);
        assertEquals(8, (int) currentData.get(1).cm);
        assertEquals(-7, (int) currentData.get(2).tempC);
        assertEquals(11, (int) currentData.get(2).cm);
    }

    @Test
    public void testGetCurrentSensorDataWithAMixOfNegativeAndPositiveNumbersInEachNewSnowReading() {
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        LinkedList<SensorReading> currentData = station.getCurrentSensorData();
        assertEquals(0, currentData.size());

        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-5, 10));
        readings.add(new SnowReading(-3, 8));
        readings.add(new SnowReading(-7, 11));
        station.readSensorData(readings);
        currentData = station.getCurrentSensorData();
        assertEquals(3, currentData.size());
    }

    @Test
    public void testSnowSensorDataForTheSensorDataAndTheSensorDataSize(){
        SnowStationSimpleOut station = new SnowStationSimpleOut();
        LinkedList<SensorReading> currentData = station.getCurrentSensorData();
        assertEquals(0, currentData.size());

        LinkedList<SensorReading> readings = new LinkedList<>();
        readings.add(new SnowReading(-4, 10));
        readings.add(new SnowReading(-2, 8));
        readings.add(new SnowReading(1, 11));
        station.readSensorData(readings);
        currentData = station.getCurrentSensorData();
        assertEquals(3, currentData.size());
    }
}