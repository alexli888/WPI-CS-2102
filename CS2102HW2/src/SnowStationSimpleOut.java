import java.util.LinkedList;
import java.util.Collections;

public class SnowStationSimpleOut implements IWeatherStation{

    private LinkedList<SensorReading> sensorData = new LinkedList<>();

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the station
     * When called multiple times, appends the new readings after the current sensor readings
     *
     * @param values A sequence of readings
     *               If the sensor has an error, the tempC or cm might be -999
     */
    @Override
    public void readSensorData(LinkedList<SensorReading> values) {
        sensorData.addAll(values);
    }

    /**
     * Retrieves the current sensor data
     *
     * @return the current sensor data (append together of multiple readings have occurred)
     * returns an empty list if there is no data
     */
    @Override
    public LinkedList<SensorReading> getCurrentSensorData() {
        return new LinkedList<>(sensorData);
    }

    /**
     * produces a sensor value of the median temperature and cm (respectively) from the stored readings ignoring error values (-999s)
     *
     * @return a new SensorReading object that has the median temperature of all the sensor values
     * and the median cm of all the sensor values
     * If there are no valid temp or cm values, then the resulting sensor reading should have -999 for that data, respectively
     */
    @Override
    public SensorReading medianReading() {
        int size = sensorData.size();
        if (size == 0) {
            return new SnowReading(-999, -999);
        }

        LinkedList<Integer> tempValues = new LinkedList<>();
        LinkedList<Integer> cmValues = new LinkedList<>();

        // Extract the temperature and cm values from the sensor data
        for (SensorReading reading : sensorData) {
            if (reading.tempC != -999) {
                tempValues.add(reading.tempC);
            }
            if (reading.cm != -999) {
                cmValues.add(reading.cm);
            }
        }

        // Sort the temperature and cm values
        Collections.sort(tempValues);
        Collections.sort(cmValues);

        // Compute the median temperature and cm
        int medianTempC = tempValues.isEmpty() ? -999 : tempValues.get(tempValues.size() / 2);
        int medianCm = cmValues.isEmpty() ? -999 : cmValues.get(cmValues.size() / 2);

        return new SnowReading(medianTempC, medianCm);
    }
}
