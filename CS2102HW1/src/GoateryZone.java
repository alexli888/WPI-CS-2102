import java.util.LinkedList;

public class GoateryZone implements IZone{
    public LinkedList<Goat> goats = new LinkedList<>();
    int piles;
    /**
     Registers a new Goat with the given attributes and adds it to the list of adoptable goats in the zone.
     @param name the name of the goat
     @param age the age of the goat in years
     @param currentWeight the current weight of the goat in grams
     @param whereabouts the current location of the goat
     @return the zone object after the new goat has been added to the list of adoptable goats
     */
   @Override
    public IZone registerAdoptable(String name, Double age, Double currentWeight, Coord whereabouts) {
        Goat g = new Goat(name, age, currentWeight, whereabouts);
        this.goats.add(g);
        return this;
    }

    /**
     Calculates the total number of young goats in the current herd.
     A young goat is defined as any goat whose age is between 0 and 12 months (inclusive).
     @return The total number of young goats in the herd.
     */
    @Override
    public int totalYoungins() {
        int total = 0;
        for (Goat g : this.goats) {
            if (g.age >= 0.0d && g.age <= 12.0d) {
                total++; // total = total + 1;
            }
        }
        return total;
    }

    /**
     Calculates the average age of young goats in the current herd.
     A young goat is defined as any goat whose age is between 0 and 12 months (inclusive).
     @return The average age of young goats in the herd, or 0 if there are no young goats in the herd.
     */
    @Override
    public double averageAge() {
        double sum = 0;
        int count = 0;
        for (Goat g : this.goats) {
            if (g.age >= 0.0d && g.age <= 12.0d) {
                sum += g.age;
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

     Adds the specified quantity of food to the current pile of edible substance for the goats and returns a string representation
     of the updated pile.
     @param food The type of food being added to the pile.
     @param quantity The quantity of the food being added to the pile.
     @return A string representation of the updated pile, in the format "Goat: X piles of edible substance",
     where X is the updated pile quantity, or "Goat: unknown piles of edible substance" if the updated pile quantity is negative.
     */
    @Override
    public String changeFeed(String food, Integer quantity) {
        this.piles += quantity;

        String pilesStr = piles >= 0 ? Integer.toString(piles) : "unknown";
        System.out.println(pilesStr);
        return String.format("Goat: %s piles of edible substance", pilesStr);
    }

    /**
     Returns the adoptable goat that is closest to the specified location.
     @param location The location to which the distance of each adoptable goat will be calculated.
     @return The adoptable goat that is closest to the specified location, or null if the herd is empty.
     */
    @Override
    public Adoptable closestTo(Coord location){
        if (this.goats.isEmpty()) {
            return null;
        }

        Goat minDistance = this.goats.get(0);


        for (Goat g: this.goats) {
            double distance = Math.sqrt(Math.pow(g.whereabouts.x- location.x, 2) + Math.pow(g.whereabouts.y - location.y, 2));

            double currentDistance = Math.sqrt(Math.pow(minDistance.whereabouts.x- location.x, 2) + Math.pow(minDistance.whereabouts.y - location.y, 2));

            if (distance <= currentDistance) {
                minDistance = g;

            }
        }

        return minDistance;


    }

    /**
     Returns a linked list of adoptable goats whose weight differs from their target weight by more than the specified threshold.
     The target weight of a goat is calculated using the formula: 55000 + (((age in months)/12)* 1000).
     @param threshold The maximum allowed difference between a goat's weight and its target weight.
     @return A linked list of adoptable goats whose weight differs from their target weight by more than the specified threshold.
     */
    @Override
    public LinkedList<Adoptable> weighIn(Double threshold) {
        LinkedList<Adoptable> overOrUnderWeight = new LinkedList<>();
        for(Goat g : goats){
            double targetWeight = 55000 + (((g.age)/12)* 1000);
            double deltaWeight = g.deltaWeight() - targetWeight;
            if (Math.abs(deltaWeight) > threshold) {
                overOrUnderWeight.add(g);
            }
        }
        return overOrUnderWeight;
    }
}
