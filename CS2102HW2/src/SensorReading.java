/**
 * A sensor reading from the weather station
 * related ot snow
 */
public abstract class SensorReading {

    /**
     * The temperature in the sensor reading for some time period in Celsius
     */
    public Integer tempC;
    /**
     * The amount of whatever was being measured in centimeters
     */
    public Integer cm;

    /**
     * Construct a weather reading from a temperature and amount (snow, rain, dust/debris, fog, etc)
     * @param tempC the temperature of the sensor reading in degrees Celsius
     * @param cm the amount of some weather phenomenon in centimeters
     */
    public SensorReading(Integer tempC, Integer cm){
        this.tempC = tempC;
        this.cm = (! cm.equals(-999)) && cm < 0 ? 0 : cm;
    }

}
