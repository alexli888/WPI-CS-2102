import java.util.ArrayList;
import java.util.LinkedList;

public class Rescue {

    /////////////
    // Autograded

    // Q1

    /**
     Calculates the total number of kittens across all litters.
     @param litters an array of integers representing the number of kittens in each litter
     @return the total number of kittens across all litters with a non-negative value
     */
    public static int totalKittens(int[] litters) {
        int total = 0; // initialize total to 0
        for (int litter : litters) {
            if (litter >= 0) {
                total += litter;
            }
        }
        return total;
    }


    // Q2

    /**
     Calculates the average age of puppies in an array of ages.
     If the age of a puppy is negative, it is assumed to be a newborn with its mother on the patio
     and its age is considered 0 for the purpose of calculating the average.
     @param puppyAges an array of doubles representing the ages of puppies
     @return the average age of the puppies, with the age of newborn puppies considered 0 for the average
     */
    public static double averagePuppyAge(double[] puppyAges) {
        int count = 0; // initialize count to 0
        double sum = 0.0; // initialize sum to 0
        for (double age : puppyAges) {
            if (age >= 0) {
                sum += age;
            } else {
                sum += 0.0; // assume newborn with mom on patio
            }
            count++;
        }
        return count > 0 ? sum / count : 0.0;
    }

    // Q3  Used Stack Overflow as reference for regex expressions

/**
    Determines if a given name is honorably titled, based on common Western name conventions.
    The function checks if the last word in the prefix of the name is a valid title, and if so,
    checks if the suffix of the name is a valid credential.
    @param name a string representing a person's name, including any titles or credentials
    @return true if the name is honorably titled, false otherwise
 */
public static boolean honorablyTitled(String name) {
    String[] parts = name.split(",\\s*"); // split name into prefix and suffix
    String[] nameParts = parts[0].split("\\s+"); // split name prefix into individual words

    // check if the last name prefix word is a valid title
    String lastWord = nameParts[nameParts.length - 1].toLowerCase();
    if (lastWord.equals("dr.") || lastWord.equals("pres.") || lastWord.matches("prince|princess|duke|duchess|baron|baroness|count|countess|judge")) {
        if (parts.length > 1) {
            String suffix = parts[1];
            // check if the suffix is a valid credential
            return suffix.matches("\\w+[.,]?\\s*(esq.|jr.|sr.|phd|md|dds)") && !suffix.contains(",");
        } else {
            return true; // no suffix
        }
    }
    return false; // invalid title
}



    // Q4
    //  "|" is used in line 62 as formatting, no other purpose

    /**
     Creates a string representing the amount of food to feed a chinchilla, including pellets, hay, and dried fruit.
     If any of the food amounts are negative, the string will show "unknown" for that amount.
     @param pellets an integer representing the amount of pellets to feed the chinchilla, in pounds
     @param hay an integer representing the amount of hay to feed the chinchilla, in ounces
     @param fruit an integer representing the amount of dried fruit to feed the chinchilla, in units
     @return a string representing the amount of food to feed the chinchilla, in the format "Chinchilla: [pellets] of pellets | [hay] of hay | [fruit] of dried fruit"
     */
    public static String chinchillaFeed(int pellets, int hay, int fruit) {
        String pelletsStr = pellets >= 0 ? pellets + " lbs." : "unknown";
        String hayStr = hay >= 0 ? hay + " oz." : "unknown";
        String fruitStr = fruit >= 0 ? fruit + " units" : "unknown";

        if (pellets < 0 && hay < 0 && fruit < 0) {
            pelletsStr = "unknown";
            hayStr = "unknown units";
            fruitStr = "unknown";
        }

        return "Chinchilla: " + pelletsStr + " of pellets | " + hayStr + " of hay | " + fruitStr + " of dried fruit";
    }



    // Q5

    /**
     Finds the coordinates of the closest cat to a given location.
     @param catCoords a linked list of Coord objects representing the coordinates of the cats
     @param location a Coord object representing the location to find the closest cat to
     @return a Coord object representing the coordinates of the closest cat to the given location, or null if the list of cat coordinates is empty
     */
    public static Coord heardingCats(LinkedList<Coord> catCoords, Coord location) {
        if (catCoords.isEmpty()) {
            return null;
        }

        double minDistance = Double.MAX_VALUE;
        Coord closestCoord = null;

        for (Coord coord : catCoords) {
            double distance = Math.sqrt(Math.pow(coord.x - location.x, 2) + Math.pow(coord.y - location.y, 2));

            if (distance < minDistance) {
                minDistance = distance;
                closestCoord = coord;
            }
        }

        return closestCoord;
    }


    // Q6

    /**
     Counts the number of goats that have a significant difference between their current weight and target weight.
     @param currentWeights an ArrayList of Double objects representing the current weights of the goats
     @param targetWeights an ArrayList of Double objects representing the target weights of the goats
     @param tolerance a double representing the maximum allowed difference between a goat's current and target weight to be considered significant
     @return an integer representing the number of goats with a significant difference between their current and target weight
     */
        public static int goatBloat(ArrayList<Double> currentWeights, ArrayList<Double> targetWeights, double tolerance) {
            int count = 0; // set count to 0
            int size = Math.min(currentWeights.size(), targetWeights.size());

            for (int i = 0; i < size; i++) {
                Double current = currentWeights.get(i);
                Double target = targetWeights.get(i);

                if (current > 0 && target > 0) {
                    double diff = Math.abs(current - target);
                    if (diff > tolerance) {
                        count++;
                    }
                }
            }

            return count;
        }


    /////////////
    // Design Portion (Q7)
    // get Min and Max temps from a double[][]

    //  "|" is used in line 62 as formatting, no other purpose

    /**
     * Prints the minimum and maximum temperatures for each row of a 2D array of temperatures.
     * @param temps a 2D array of double values representing temperatures for each row
     * @return doesn't return any value, instead prints out info to console
     */

    public static Object findMinMaxTemps(double[][] temps) {
        for (int i = 0; i < temps.length; i++) {
            double minTemp = Double.MAX_VALUE;
            double maxTemp = Double.MIN_VALUE;
            for (int j = 0; j < temps[i].length; j++) {
                if (temps[i][j] < minTemp) {
                    minTemp = temps[i][j];
                }
                if (temps[i][j] > maxTemp) {
                    maxTemp = temps[i][j];
                }
            }
            System.out.println("Newborn " + (i + 1) + " - Min Temp: " + minTemp + " | Max Temp: " + maxTemp);
        }
        return null;
    }
}





