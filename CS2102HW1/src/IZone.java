import java.util.LinkedList;

/**
 * An area where adoptable pets-to-be hangout
 */
public interface IZone {

    /**
     * Creates an appropriate adoptable pet-to-be's profile
     * @param name
     * @param age
     * @param currentWeight
     * @param whereabouts
     * @return
     */
    IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts);

    /**
     * Calculates the total number of adoptable pets-to-be in the zone that are >= 0 and <= 12 months old
     * @return the calculated total
     */
    int totalYoungins();

    /**
     * Calculates the average age of the adoptable pets-to-be in the zone.
     * If an adoptable pet-to-be is pregnant with a known number of babies-to-be,
     * Each of their ages counts as 0.0d
     * @return the average age
     */
    double averageAge();

    /**
     * changes the feed stores of the zone,
     * Generates a string label for the zone pantry marquee
     * @param food the type of food being added
     * @param quantity the amount of food being added or subtracked
     * @return a string of the form "Species: # unit of food-type | ..."
     *         where # is either a number or the text "unknown" if the amount is currently < 0
     */
    String changeFeed(String food, Integer quantity);

    /**
     * Using the last known sensor data for an adoptable, finds the closest adoptable to some location
     * @param location the 2D top-down coordinate we are searching near
     * @return The data profile of the adoptable last-seen nearest to that coordinate or null if the zone is empty
     * If two adoptables are equal distances from a coord, produce the one added to the zone latest.
     */
    Adoptable closestTo(Coord location);

    /** Find the adoptable pets-to-be in the zone that are strictly over or under weight
     * @param threshold a threshold of how over or under weight each adoptable pet-to-be can be
     * @return The list of adoptable animals that are currently beyond (> or <) the threshold of their target weight
     */
    LinkedList<Adoptable> weighIn(Double threshold);

}
