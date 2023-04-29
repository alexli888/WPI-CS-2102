import org.junit.Assert; // make sure to use junit 4!!!
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// MY TESTS

// Q1 Tests
public class Examples {
    @Test // Test for all positive numbers array
        public void testTotalkittens_AllPositiveNumbers() {
        int[] litters = {2, 3, 4, 1, 5};
        int expectedTotal = 15;
        int actualTotal = Rescue.totalKittens(litters);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test // test for all negative numbers array
        public void testTotalkittens_AllNegativeNumbers() {
        int[] litters = {-2, -3, -4, -1, -5};
        int expectedTotal = 0;
        int actualTotal = Rescue.totalKittens(litters);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test // test for a mixed array of kittens
        public void testTotalKittens_MixedNumbers() {
        int[] litters = {2, -3, 4, -1, 5};
        int expectedTotal = 11;
        int actualTotal = Rescue.totalKittens(litters);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test // test for empty array of kittens
        public void testTotalKittens_EmptyArray() {
        int[] litters = {};
        int expectedTotal = 0;
        int actualTotal = Rescue.totalKittens(litters);
        assertEquals(expectedTotal, actualTotal);
    }

// Q2 Tests
    @Test // test for all negative ages array
        public void testAveragePuppyAge_AllNegativeAges() {
        double[] puppyAges = {-2.5, -3.0, -4.5, -1.5, -5.0};
        double expectedAverage = 0.0;
        double actualAverage = Rescue.averagePuppyAge(puppyAges);
        assertEquals(expectedAverage, actualAverage, 0.001);
    }

    @Test // test for empty array
        public void testAveragePuppyAge_EmptyArray() {
        double[] puppyAges = {};
        double expectedAverage = 0.0;
        double actualAverage = Rescue.averagePuppyAge(puppyAges);
        assertEquals(expectedAverage, actualAverage, 0.001);
    }

    // Q3 Tests
        @Test // test for invalid title
        public void testHonorablyTitled_InvalidTitle() {
            assertFalse(Rescue.honorablyTitled("John Smith, Manager"));
        }

        @Test // test for invalid suffix
        public void testHonorablyTitled_InvalidSuffix() {
            assertFalse(Rescue.honorablyTitled("John Smith, Esq., Jr."));
        }

        @Test // test for a honorably titled
        public void testHonorablyTitled() {
        String name = "Ms. Jane Doe, MD";
        boolean result = Rescue.honorablyTitled(name);
        assertTrue(result);
    }

    @Test
    public void testValidName() {
        String name = "Prince John Smith, PhD";
        assertTrue(Rescue.honorablyTitled(name));
    }

    @Test
    public void testNoSuffix() {
        String name = "Baroness Jane Brown";
        assertTrue(Rescue.honorablyTitled(name));
    }

    @Test
    public void testInvalidTitle() {
        String name = "Mr. John Doe, Esq.";
        assertFalse(Rescue.honorablyTitled(name));
    }

    @Test
    public void testInvalidSuffix() {
        String name = "Duchess Mary Jones, ABC";
        assertFalse(Rescue.honorablyTitled(name));
    }

    @Test // test for abbreviated title
        public void testAbbreviatedTitles() {
        assertFalse(Rescue.honorablyTitled("Mr. John Smith"));
        assertFalse(Rescue.honorablyTitled("Mrs. Jane Doe"));
        assertFalse(Rescue.honorablyTitled("Ms. Sarah Lee"));
    }

// Q4 Tests
    @Test // test for positive values
        public void testChinchillaFeedWithPositiveValues() {
        String expected = "Chinchilla: 5 lbs. of pellets | 8 oz. of hay | 3 units of dried fruit";
        String actual = Rescue.chinchillaFeed(5, 8, 3);
        assertEquals(expected, actual);
    }

    @Test // test for negative values
        public void testChinchillaFeedWithNegativeValues() {
        String expected = "Chinchilla: unknown of pellets | unknown of hay | unknown of dried fruit";
        String actual = Rescue.chinchillaFeed(-1, -1, -1);
        assertEquals(expected, actual);
    }

    @Test // test for mixed values
        public void testChinchillaFeedWithMixedValues() {
        String expected = "Chinchilla: 3 lbs. of pellets | unknown of hay | 2 units of dried fruit";
        String actual = Rescue.chinchillaFeed(3, -1, 2);
        assertEquals(expected, actual);
    }

    // Q5 Tests
        @Test // test for empty list
        public void testHerdingCatsWithEmptyList() {
            LinkedList<Coord> catCoords = new LinkedList<>();
            Coord location = new Coord(0, 0);
            Coord expected = null;
            Coord actual = Rescue.heardingCats(catCoords, location);
            assertEquals(expected, actual);
        }
        @Test // test for empty linked list
        public void testHerdingCatsWithEmptyLinkedList() {
        LinkedList<Coord> catCoords = new LinkedList<>();
        Coord location = new Coord(0, 0);

        Coord result = Rescue.heardingCats(catCoords, location);
        assertNull(result);
    }

        @Test // test for single coords
        public void testHerdingCatsWithSingleCoordinate() {
        LinkedList<Coord> catCoords = new LinkedList<>();
        catCoords.add(new Coord(2, 2));

        Coord location = new Coord(0, 0);

        Coord result = Rescue.heardingCats(catCoords, location);
        assertEquals(catCoords.getFirst(), result);
    }

        @Test // test for multiple coords
        public void testHerdingCatsWithMultipleCoordinates() {
        LinkedList<Coord> catCoords = new LinkedList<>();
        catCoords.add(new Coord(2, 2));
        catCoords.add(new Coord(3, 3));
        catCoords.add(new Coord(4, 4));

        Coord location = new Coord(0, 0);

        Coord result = Rescue.heardingCats(catCoords, location);
        assertEquals(catCoords.getFirst(), result);
    }

        // Q6 Tests
     @Test // test for empty list
        public void testGoatBloat_emptyList() {
        ArrayList<Double> currentWeights = new ArrayList<>();
        ArrayList<Double> targetWeights = new ArrayList<>();
        double tolerance = 0.1;

        int expected = 0;
        int actual = Rescue.goatBloat(currentWeights, targetWeights, tolerance);

        assertEquals(expected, actual);
    }

    @Test // test for single weight below tolerance
        public void testGoatBloat_singleWeightBelowTolerance() {
        ArrayList<Double> currentWeights = new ArrayList<>();
        currentWeights.add(1.0);
        ArrayList<Double> targetWeights = new ArrayList<>();
        targetWeights.add(1.0);
        double tolerance = 0.1;

        int expected = 0;
        int actual = Rescue.goatBloat(currentWeights, targetWeights, tolerance);

        assertEquals(expected, actual);
    }

    @Test // test for single wright above tolerance
        public void testGoatBloat_singleWeightAboveTolerance() {
        ArrayList<Double> currentWeights = new ArrayList<>();
        currentWeights.add(1.2);
        ArrayList<Double> targetWeights = new ArrayList<>();
        targetWeights.add(1.0);
        double tolerance = 0.1;

        int expected = 1;
        int actual = Rescue.goatBloat(currentWeights, targetWeights, tolerance);

        assertEquals(expected, actual);
    }

    @Test // test for different list sizes
        public void testGoatBloat_differentListSizes() {
        ArrayList<Double> currentWeights = new ArrayList<>();
        currentWeights.add(1.1);
        currentWeights.add(2.2);
        ArrayList<Double> targetWeights = new ArrayList<>();
        targetWeights.add(1.0);
        targetWeights.add(2.0);
        targetWeights.add(3.0);
        double tolerance = 0.1;

        int expected = 2;
        int actual = Rescue.goatBloat(currentWeights, targetWeights, tolerance);

        assertEquals(expected, actual);
    }

    @Test // edge case test
        public void testGoatBloat_edge() {
        ArrayList<Double> currentWeights = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        ArrayList<Double> targetWeights = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        double tolerance = 0.5;

        // Add a few elements to the end of the ArrayLists with integer values
        currentWeights.add(6.0);
        targetWeights.add(6.0);
        currentWeights.add(7.0);
        targetWeights.add(7.0);

        // Test the method and assert that it returns the correct value
        int count = Rescue.goatBloat(currentWeights, targetWeights, tolerance);
        assertEquals(0, count);
    }
    @Test // edge case test
    public void testGoatBloat_edge2() {
        ArrayList<Double> currentWeights = new ArrayList<>(Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        ArrayList<Double> targetWeights = new ArrayList<>(Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 10.0));
        double tolerance = 1.0;
        int result = Rescue.goatBloat(currentWeights, targetWeights, tolerance);
        assertEquals(0, result);
    }

}