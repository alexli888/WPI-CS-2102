import java.util.*;
/**
 The DailyRatingsCollection interface represents a collection of DailyRatings objects, which contain analytics data for a particular entity.
 This interface provides methods for adding a new DailyRatings object to the collection, as well as retrieving all DailyRatings objects in the collection.
 */
public interface DailyRatingsCollection {

    /**
     * Adds the specified DailyRatings object to the collection.
     *
     * @param dailyRatings the DailyRatings object to add to the collection.
     */
    void add(DailyRatings dailyRatings);

    /**
     * Returns a list of all DailyRatings objects in the collection.
     *
     * @return a list of all DailyRatings objects in the collection.
     */
    List<DailyRatings> getAll();
}