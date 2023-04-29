import java.util.LinkedList;

public class TheHutchZone implements IZone{
    LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
    int pellets = 0;
    int hay = 0;
    int fruit = 0;
    /**
     Registers a new adoptable Chinchilla to this zone.
     @param name the name of the Chinchilla
     @param age the age of the Chinchilla in years
     @param currentWeight the current weight of the Chinchilla in grams
     @param whereabouts the current location of the Chinchilla in the zone
     @return the current zone with the newly added Chinchilla
     */
    @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Chinchilla ch = new Chinchilla(name, age, currentWeight, whereabouts);
        this.chinchillas.add(ch);
        return this;
    }

    /**
     Calculates the total number of young Chinchillas in the zone.
     A young Chinchilla is defined as one whose age is between 0 and 12 months (inclusive).
     @return The total number of young Chinchillas in the zone.
     */
    @Override
    public int totalYoungins() {
        int total = 0;
        for (Chinchilla ch : this.chinchillas) {
            if (ch.age >= 0.0d && ch.age <= 12.0d) {
                total++; // total = total + 1;
            }
        }
        return total;
    }

    /**
     Calculates the average age of all the young (ages between 0 and 12 inclusive) chinchillas in this zone.
     @return the average age of young chinchillas in this zone, or 0 if there are no young chinchillas
     */
    @Override
    public double averageAge() {
        double sum = 0;
        int count = 0;
        for (Chinchilla ch : this.chinchillas) {
            if (ch.age >= 0.0d && ch.age <= 12.0d) {
                sum += ch.age;
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
     Changes the amount of food given to the chinchillas.
     @param food the type of food to change, either "pellets", "hay", or "fruit".
     @param quantity the quantity of food to add.
     @return a string with the updated amount of food for each type.
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        if (food.equals("pellets")) {
            this.pellets += quantity;
        } else if (food.equals("hay")) {
            this.hay += quantity;
        } else if (food.equals("fruit")) {
            this.fruit += quantity;
        }
        return String.format("Chinchilla: %s lbs. of pellets | %s oz. of hay | %s units of dried fruit", this.pellets, this.hay, this.fruit);
    }

    /**
     Returns the adoptable animal in this zone that is closest to a given location.
     If there are no animals in this zone, returns null.
     @param location the location to which the distance will be measured
     @return the adoptable animal in this zone that is closest to the given location,
     or null if there are no animals in this zone
     */
    @Override
    public Adoptable closestTo(Coord location){
        if (this.chinchillas.isEmpty()) {
            return null;
        }

        Chinchilla minDistance = this.chinchillas.get(0);


        for (Chinchilla ch: this.chinchillas) {
            double distance = Math.sqrt(Math.pow(ch.whereabouts.x- location.x, 2) + Math.pow(ch.whereabouts.y - location.y, 2));

            double currentDistance = Math.sqrt(Math.pow(minDistance.whereabouts.x- location.x, 2) + Math.pow(minDistance.whereabouts.y - location.y, 2));

            if (distance <= currentDistance) {
                minDistance = ch;

            }
        }

        return minDistance;
    }

    /**
     Returns a linked list of all chinchillas in the hutch whose weight is outside the given threshold
     compared to the average weight of all chinchillas in the hutch.
     @param threshold the maximum deviation from the average weight of chinchillas in the hutch
     @return a linked list of chinchillas whose weight is outside the threshold
     */

    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> overOrUnderWeight = new LinkedList<>();
        double avgChinchillaWeight = 0;
        int numChinchillas = 0;

        // calculate average weight of all chinchillas in the hutch
        for (Chinchilla ch : this.chinchillas) {
            avgChinchillaWeight += ch.currentWeight;
            numChinchillas++;
        }
        if (numChinchillas > 0) {
            avgChinchillaWeight /= numChinchillas;
        }

        // check which chinchillas are over or under weight
        for (Chinchilla ch : this.chinchillas) {
            double deltaWeight = ch.currentWeight - avgChinchillaWeight;
            if (Math.abs(deltaWeight) > threshold) {
                overOrUnderWeight.add(ch);
            }
        }
        return overOrUnderWeight;
    }

}

