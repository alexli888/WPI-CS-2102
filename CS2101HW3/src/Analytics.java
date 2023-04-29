/**
 * The Analytics class represents the analytics data for a particular entity, which includes its rank and the number of subscribers it has.
 * This class contains a constructor to initialize the rank and subscribers data, as well as getter methods to retrieve the rank and subscribers values.
 * Example Usage: // create a new Analytics object Analytics analytics = new Analytics(1, 10000);
 * // get the rank of the entity int rank = analytics.getRank();
 * // get the number of subscribers of the entity int subscribers = analytics.getSubscribers();
 * */

public class Analytics {
    private int rank;
    private int subscribers;

    /**
     Constructs an Analytics object with the specified rank and number of subscribers.
     @param rank the rank of the entity
     @param subscribers the number of subscribers of the entity
     */
    public Analytics(int rank, int subscribers) {
        this.rank = rank;
        this.subscribers = subscribers;
    }

    /**
     Returns the rank of the entity.
     @return the rank of the entity
     */
    public int getRank() {
        return rank;
    }

    /**
     Returns the number of subscribers of the entity.
     @return the number of subscribers of the entity
     */
    public int getSubscribers() {
        return subscribers;
    }
}