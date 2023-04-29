import java.util.*;

/**
 The DailyRatings class represents the daily ratings data for a particular entity, which includes the date, the rankings, and the number of subscribers.
 This class contains a constructor to initialize the date, rankings, and subscribers data, as well as getter methods to retrieve the date, rankings, and subscribers values.
 The class also provides unmodifiable views of the rankings and subscribers lists to prevent modification from external sources.
 */
public class DailyRatings {
    private final GregorianCalendar date;
    private final LinkedList<Integer> rankings;
    private final LinkedList<Integer> subscribers;

    public DailyRatings(GregorianCalendar date, LinkedList<Integer> rankings, LinkedList<Integer> subscribers) {
        this.date = (GregorianCalendar) date.clone();
        this.rankings = new LinkedList<>(rankings);
        this.subscribers = new LinkedList<>(subscribers);
    }

    /**
     *  Returns a clone of the date object representing the date of this DailyRatings object.
     *  @return a clone of the date object representing the date of this DailyRatings object.
     */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) date.clone();
    }

    /**
     * Returns an unmodifiable view of the rankings list for this DailyRatings object.
     * @return an unmodifiable view of the rankings list for this DailyRatings object.
     */
    public List<Integer> getRankings() {
        return Collections.unmodifiableList(rankings);
    }

    /**
     * Returns an unmodifiable view of the subscribers list for this DailyRatings object.
     * @return an unmodifiable view of the subscribers list for this DailyRatings object.
     */
    public List<Integer> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
    }
}