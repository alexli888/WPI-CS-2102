import java.util.*;
public class Streamometer {
    private final DailyRatingsCollection dailyRatingsCollection;
    private final GregorianCalendar today;
    /**
     * The Streamometer class represents a tool for analyzing daily ratings data.
     * It stores a DailyRatingsCollection object and a GregorianCalendar object representing the current date.
     *
     * The class provides methods for calculating the best rank in the current month, the total subscribers in a given month and year,
     * and for adding today's analytics data to the DailyRatingsCollection object.
     *
     * @param dailyRatingsCollection a DailyRatingsCollection object containing daily ratings data
     * @param today a GregorianCalendar object representing the current date
     */
    public Streamometer(DailyRatingsCollection dailyRatingsCollection, GregorianCalendar today) {
        this.dailyRatingsCollection = dailyRatingsCollection;
        this.today = (GregorianCalendar) today.clone();
    }

    /**
     * Returns the best rank achieved by the stream in the current month.
     *
     * @return the best rank achieved by the stream in the current month.
     */
    public int bestRankThisMonth() {
        int currentMonth = today.get(GregorianCalendar.MONTH);
        int currentYear = today.get(GregorianCalendar.YEAR);
        int bestRank = Integer.MAX_VALUE;
        for (DailyRatings dailyRating : dailyRatingsCollection.getAll()) {
            if (dailyRating.getDate().get(GregorianCalendar.MONTH) == currentMonth &&
                    dailyRating.getDate().get(GregorianCalendar.YEAR) == currentYear) {
                for (int rank : dailyRating.getRankings()) {
                    if (rank < bestRank) {
                        bestRank = rank;
                    }
                }
            }
        }
        return bestRank;
    }

    /**
     * Returns the total number of subscribers for a given month and year.
     *
     * @param month the month for which to calculate the total subscribers
     * @param year the year for which to calculate the total subscribers
     * @return the total number of subscribers for the specified month and year.
     */
    public int totalSubscribers(int month, int year) {
        int total = 0;
        for (DailyRatings dailyRating : dailyRatingsCollection.getAll()) {
            if (dailyRating.getDate().get(GregorianCalendar.MONTH) == month &&
                    dailyRating.getDate().get(GregorianCalendar.YEAR) == year) {
                for (int subscribers : dailyRating.getSubscribers()) {
                    total += subscribers;
                }
            }
        }
        return total;
    }

    /**
     * Adds today's analytics data to the DailyRatingsCollection object.
     *
     * @param analytics a list of Analytics objects representing today's analytics data
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics) {
        LinkedList<Integer> rankings = new LinkedList<>();
        LinkedList<Integer> subscribers = new LinkedList<>();
        for (Analytics analytic : analytics) {
            rankings.add(analytic.getRank());
            subscribers.add(analytic.getSubscribers());
        }
        DailyRatings dailyRating = new DailyRatings(today, rankings, subscribers);
        dailyRatingsCollection.add(dailyRating);
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
    }
}