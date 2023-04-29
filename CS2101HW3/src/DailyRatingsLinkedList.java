import java.util.*;
/**
 The DailyRatingsLinkedList class implements the DailyRatingsCollection Interface and represents a collection of DailyRatings objects.
 This class is implemented using a LinkedList data structure and provides methods
 to add a DailyRatings object to the end of the list and to retrieve an unmodifiable view of the list of DailyRatings objects.
 */
public class DailyRatingsLinkedList implements DailyRatingsCollection {
    private final LinkedList<DailyRatings> dailyRatings;

    /**
     * Constructs a new DailyRatingsLinkedList object that is initially empty.
     */
    public DailyRatingsLinkedList() {
        dailyRatings = new LinkedList<>();
    }

    /**
     * Adds the specified DailyRatings object to the end of the list.
     *
     * @param dailyRatings the DailyRatings object to add to the end of the list.
     */
    @Override
    public void add(DailyRatings dailyRatings) {
        this.dailyRatings.add(dailyRatings);
    }

    /**
     * Returns an unmodifiable view of the list of DailyRatings objects.
     *
     * @return an unmodifiable view of the list of DailyRatings objects.
     */
    @Override
    public List<DailyRatings> getAll() {
        return Collections.unmodifiableList(dailyRatings);
    }
}
