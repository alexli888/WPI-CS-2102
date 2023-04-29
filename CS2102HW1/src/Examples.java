import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {

    /* @Test
     public void test_coord1(){
         Coord c1 = new Coord(0,0);
         Coord c2 = new Coord(3,4);
         assertEquals(5.0d, c1.distanceFrom(c2), 0.01d);
     }
 */
    @Test
    public void test_catast_totalYoungins(){
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0,0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1,1));

        assertEquals(1, cz.totalYoungins());
    }

    @Test
    public void test_catast_totalYoungins2(){
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Ginger", 12.0d, 4500.0d, new Coord (0,2));
        cz.registerAdoptable("Higgins", 6.5d, 2000.0d, new Coord(2,3));
        cz.registerAdoptable("Muffin", 32.6d, 5000.0d, new Coord(-1,-1));

        assertEquals(2, cz.totalYoungins() );
    }

    @Test
    public void test_catast_totalYounginsNoCats(){
        CatastropheZone cz = new CatastropheZone();
        assertEquals(0, cz.totalYoungins());
    }

    @Test
    public void test_catast_catFeed(){
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("dry",100);

        assertEquals("Cat: 100 lbs. of dry food | 0 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeed2(){
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("wet",100);

        assertEquals("Cat: 0 lbs. of dry food | 100 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeedInvalidFood() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("invalid", 100);

        assertEquals("Cat: 0 lbs. of dry food | 0 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeedDryZeroQuantity() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("dry", 0);

        assertEquals("Cat: 0 lbs. of dry food | 0 cans of wet food", s);
    }

    @Test
    public void test_catast_catFeedWetZeroQuantity() {
        CatastropheZone cz = new CatastropheZone();
        String s = cz.changeFeed("wet", 0);

        assertEquals("Cat: 0 lbs. of dry food | 0 cans of wet food", s);
    }


    @Test
    public void test_catast_averageAge() {
        // create a CatastropheZone object with some adoptable cats already registered
        CatastropheZone cz = new CatastropheZone();
        // these cats are already registered in the cz object
        cz.registerAdoptable("F", 12.0d,5.0d, null);
        cz.registerAdoptable("Sprinkles", 6.5d, 2000.0d, null);

        // calculate the actual average age using the CatastropheZone object
        double actual = cz.averageAge();



        // assert that the actual average age equals the expected average age
        assertEquals(18.5d/2.0d, actual, 0.01d);
    }

    @Test
    public void test_catast_averageAge2(){
        CatastropheZone cz = new CatastropheZone();
        cz.registerAdoptable("Ginger", 12.0d, 4500.0d, new Coord (0,2));
        cz.registerAdoptable("Higgins", 6.5d, 2000.0d, new Coord(2,3));
        cz.registerAdoptable("Muffin", 32.6d, 5000.0d, new Coord(-1,-1));

        double actual = cz.averageAge();

        assertEquals(51.1d/3d, actual, 0.01d );
    }

    @Test
    public void testClosestTo2() {
        // Create a CatastropheZone object
        CatastropheZone cz = new CatastropheZone();

        // Register some adoptables
        cz.registerAdoptable("Fluffy", 9.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 24.0d, 5000.0d, new Coord(1, 1));

        // Find the adoptable closest to a location
        Adoptable closest = cz.closestTo(new Coord(0, 0));

        // Check that the closest adoptable is Fluffy
        assertEquals("Fluffy", closest.getName());
    }
    /*@Test
    public void testWeighIn() {
        // Create a CatastropheZone object
        CatastropheZone cz = new CatastropheZone();

        // Register some adoptables
        cz.registerAdoptable("Fluffy", 2.0d, 4000.0d, new Coord(0, 0));
        cz.registerAdoptable("Sprinkles", 3.0d, 5000.0d, new Coord(1, 1));

        LinkedList<Adoptable> overOrUnderWeight = cz.weighIn(200.0d);

        // Check that only Sprinkles is over their target weight
        assertEquals(1, overOrUnderWeight);

    }
    */


    @Test
    public void test_hutch_averageAge1(){
        TheHutchZone ch = new TheHutchZone();
        ch.registerAdoptable("Gizmo", 14.0d, 4200.0d, new Coord (1,2));
        ch.registerAdoptable("Dusty", 21.0d, 5200.0d, new Coord (-1,0));
        double actual = ch.averageAge();
        assertEquals(35.0d / 2.0d, actual, 0.01d);
    }


}
