import java.util.LinkedList;

public class CatastropheZone implements IZone {

    LinkedList<Cat> cats = new LinkedList<Cat>();
    int dry = 0;
    int wet = 0;

    /**
     Registers a new adoptable cat in the zone by adding it to the list of cats and returns the updated zone.
     @param name The name of the new cat.
     @param age The age of the new cat, in years.
     @param currentWeight The current weight of the new cat, in pounds.
     @param whereabouts The current whereabouts of the new cat, represented by a Coord object.

     @return The updated zone with the new cat added to the list of cats.
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Cat c = new Cat(name, age, currentWeight, whereabouts);
        this.cats.add(c);
        return this;
    }

    /**
     Counts the number of young cats in the zone and returns the total count.
     @return An integer representing the total number of cats in the zone that are between 0 and 12 years old.
     */
    @Override
    public int totalYoungins() {
        int total = 0;
        for (Cat c : this.cats) {
            if (c.age >= 0.0d && c.age <= 12.0d) {
                total++; // total = total + 1;
            }
        }
        return total;
    }

    /**
     * Calculates the average age of young cats in the zone and returns the result.
     *
     * @return A double representing the average age of cats in the zone that are between 0 and 12 years old.
       If there are no cats that meet this criteria, returns 0.
     */
    @Override
    public double averageAge() {
        double sum = 0;
        int count = 0;
        for (Cat c : this.cats) {
            if (c.age >= 0.0d && c.age <= 12.0d) {
                sum += c.age;
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        } else {
            return 0;
        }
    }


    /**
     Changes the quantity of a specified type of food for the cats in the zone and returns a String representing the updated amount of food.
     @param food The type of food to change the quantity of ("dry" or "wet").
     @param quantity The amount to add or subtract from the current quantity of the specified type of food.
     @return A formatted String representing the updated amount of food for the cats in the zone, with the format
     "Cat: [lbs. of dry food] lbs. of dry food | [cans of wet food] cans of wet food".
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        if (food.equals("dry")) {
            this.dry += quantity;
        } else if (food.equals("wet")) {
            this.wet += quantity;
        }
        return String.format("Cat: %s lbs. of dry food | %s cans of wet food", this.dry, this.wet);
    }

    /**
     * Using the last known sensor data for an adoptable(cat), finds the closest adoptable(Cat) to some location
     *
     * @param location the 2D top-down coordinate we are searching near
     * @return The data profile of the adoptable last-seen nearest to that coordinate or null if the zone is empty
     * If two adoptables(cat) are equal distances from a coord, produce the one added to the zone latest.
     */
    @Override
    public Adoptable closestTo(Coord location){
        if (this.cats.isEmpty()) {
            return null;
        }

        Cat minDistance = this.cats.get(0);


        for (Cat c: this.cats) {
            double distance = Math.sqrt(Math.pow(c.whereabouts.x- location.x, 2) + Math.pow(c.whereabouts.y - location.y, 2));

            double currentDistance = Math.sqrt(Math.pow(minDistance.whereabouts.x- location.x, 2) + Math.pow(minDistance.whereabouts.y - location.y, 2));

            if (distance <= currentDistance) {
                minDistance = c;

            }
        }

        return minDistance;


    }



    /**
     Returns a linked list of all adoptable cats in this zone whose weight deviates from their target weight by more than the given threshold.
     @param threshold the maximum deviation from the target weight allowed to include an adoptable cat in the result list
     @return a linked list of all adoptable cats in this zone whose weight deviates from their target weight by more than the given threshold
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> overOrUnderWeight = new LinkedList<>();
        for (Cat c : this.cats) {
            double targetWeight = (c.age >= 2.0) ? 4500.0 : c.currentWeight;
            double deltaWeight = c.deltaWeight() - targetWeight;
            if (Math.abs(deltaWeight) > threshold) {
                overOrUnderWeight.add(c);
            }
        }
        return overOrUnderWeight;
    }
}

