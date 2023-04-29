import java.util.Objects;
public class SnowReading extends SensorReading {

    /**
     * Construct a SnowReading object with temperature and amount of snow
     *
     * @param tempC temperature in degrees Celsius
     * @param cm amount of snow in centimeters
     */
    public SnowReading(Integer tempC, Integer cm) {
        super(tempC, cm);
    }

    /**
     * Defines a no-argument constructor that initializes the super constructor with -999 for both parameters.
     */
    public SnowReading() {
        super(-999, -999);
    }

    /**
     * Returns true if the parameter object is an instance of SnowReading and has the same tempC and cm values
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnowReading that = (SnowReading) o;
        return Objects.equals(tempC, that.tempC) && Objects.equals(cm, that.cm);
    }

    /**
     * Returns a string representation of the SnowReading object in the format of "tempC:CelsiusValue, cm:CentimetersValue"
     * If either tempC or cm is -999, the corresponding part of the string will be replaced with "Err"
     */
    @Override
    public String toString() {
        String tempString = tempC == -999 ? "Err" : tempC + "C";
        String cmString = cm == -999 ? "Err" : cm + "cm";
        return tempString + ":" + cmString;
    }
}
