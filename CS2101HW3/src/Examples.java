import org.junit.Test;
import junit.*;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void testBestRankThisMonth() {
        GregorianCalendar today = new GregorianCalendar(2023, 3, 4); // April 4, 2023
        DailyRatingsCollection dailyRatingsCollection = new DailyRatingsLinkedList();

        // Add some past daily ratings
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 3, 1), new LinkedList<>(Arrays.asList(3, 4)), new LinkedList<>(Arrays.asList(100, 150))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 27), new LinkedList<>(Arrays.asList(1, 5)), new LinkedList<>(Arrays.asList(200, 180))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 26), new LinkedList<>(Arrays.asList(2, 1)), new LinkedList<>(Arrays.asList(150, 250))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 25), new LinkedList<>(Arrays.asList(6, 3)), new LinkedList<>(Arrays.asList(80, 120))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 24), new LinkedList<>(Arrays.asList(4, 7)), new LinkedList<>(Arrays.asList(90, 110))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 23), new LinkedList<>(Arrays.asList(8, 2)), new LinkedList<>(Arrays.asList(60, 180))));

        // Add today's daily ratings
        Streamometer streamometer = new Streamometer(dailyRatingsCollection, today);
        streamometer.addTodaysAnalytics(new LinkedList<>(Arrays.asList(new Analytics(2, 200), new Analytics(5, 300))));

        assertEquals(2, streamometer.bestRankThisMonth());
    }

    @Test
    public void testDailyRatings() {
        GregorianCalendar date = new GregorianCalendar(2023, 3, 4); // April 4, 2023
        LinkedList<Integer> rankings = new LinkedList<>(Arrays.asList(3, 4));
        LinkedList<Integer> subscribers = new LinkedList<>(Arrays.asList(100, 150));

        DailyRatings dailyRatings = new DailyRatings(date, rankings, subscribers);

        assertEquals(date, dailyRatings.getDate());
        assertEquals(rankings, dailyRatings.getRankings());
        assertEquals(subscribers, dailyRatings.getSubscribers());
    }

    @Test
    public void testAddAndGetAll() {
        DailyRatingsCollection dailyRatingsCollection = new DailyRatingsLinkedList();

        // Create some DailyRatings objects
        DailyRatings ratings1 = new DailyRatings(new GregorianCalendar(2023, 3, 1), new LinkedList<>(Arrays.asList(3, 4)), new LinkedList<>(Arrays.asList(100, 150)));
        DailyRatings ratings2 = new DailyRatings(new GregorianCalendar(2023, 2, 27), new LinkedList<>(Arrays.asList(1, 5)), new LinkedList<>(Arrays.asList(200, 180)));

        // Add the DailyRatings objects to the collection
        dailyRatingsCollection.add(ratings1);
        dailyRatingsCollection.add(ratings2);

        // Retrieve all DailyRatings objects from the collection
        List<DailyRatings> allRatings = dailyRatingsCollection.getAll();

        // Verify that the retrieved list contains the expected DailyRatings objects in the expected order
        assertEquals(ratings1, allRatings.get(0));
        assertEquals(ratings2, allRatings.get(1));
    }

    @Test
    public void testAnalyticsClass() {
        Analytics analytics = new Analytics(1, 200);
        assertEquals(1, analytics.getRank());
        assertEquals(200, analytics.getSubscribers());
    }

    @Test
    public void test_streamometerBestRankThisMonthAgain(){
        GregorianCalendar today = new GregorianCalendar(2023, 2, 30); // March 30, 2023
        DailyRatingsCollection dailyRatingsCollection = new DailyRatingsLinkedList();

        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 3, 1), new LinkedList<>(Arrays.asList(3, 4)), new LinkedList<>(Arrays.asList(100, 150))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 27), new LinkedList<>(Arrays.asList(1, 5)), new LinkedList<>(Arrays.asList(200, 180))));
        dailyRatingsCollection.add(new DailyRatings(new GregorianCalendar(2023, 2, 26), new LinkedList<>(Arrays.asList(2, 1)), new LinkedList<>(Arrays.asList(150, 250))));
        // Add today's ratings
        Streamometer streamometer = new Streamometer(dailyRatingsCollection, today);
        streamometer.addTodaysAnalytics(new LinkedList<>(Arrays.asList(new Analytics(2, 200), new Analytics(5, 300))));
        assertEquals(1, streamometer.bestRankThisMonth());
    }


}