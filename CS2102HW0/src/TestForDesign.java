import static org.junit.Assert.assertEquals;
import org.junit.Test;

// Test for the Design portion (Q7) of HW0
public class TestForDesign {
    @Test
    public void testFindMinMaxTemps() {
        double[][] temps = {{98.6, 97.2, 99.1}, {100.3, 102.5, 99.8}};
        String expectedOutput = "Newborn 1 - Min Temp: 97.2 | Max Temp: 99.1\n" +
                "Newborn 2 - Min Temp: 99.8 | Max Temp: 102.5\n";
        assertEquals(expectedOutput, Rescue.findMinMaxTemps(temps));
    }
}
