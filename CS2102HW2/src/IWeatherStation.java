import java.util.LinkedList;

public interface IWeatherStation {

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the station
     * When called multiple times, appends the new readings after the current sensor readings
     * @param values A sequence of readings
     *               If the sensor has an error, the tempC or cm might be -999
     */
    public void readSensorData(LinkedList<SensorReading> values);

    /**
     * Retrieves the current sensor data
     * @return the current sensor data (append together of multiple readings have occurred)
     *         returns an empty list if there is no data
     */
    public LinkedList<SensorReading> getCurrentSensorData();

    /**
     * produces a sensor value of the median temperature and cm (respectively) from the stored readings ignoring error values (-999s)
     * @return a new SensorReading object that has the median temperature of all the sensor values
     *         and the median cm of all the sensor values
     *         If there are no valid temp or cm values, then the resulting sensor reading should have -999 for that data, respectively
     */
    public SensorReading medianReading();


}
