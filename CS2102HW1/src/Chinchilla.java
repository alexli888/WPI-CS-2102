import java.util.ArrayList;
public class Chinchilla extends Adoptable{
    /**
     * Creates a profile for an adoptable pet-to-be
     *
     * @param name          the name of the animal with no title(s) nor credential(s)
     * @param age           the age of the pet in months
     * @param currentWeight the current weight of the pet in grams
     * @param whereabouts   the last known location of the pet as a 2D coordinate
     */
    public Chinchilla(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }
    private static ArrayList<Chinchilla> chinchillas;

    /**
     Calculates the difference in weight between the current chinchilla and the average weight of all chinchillas
     in the hutch.

     @return The absolute value of the difference between the current chinchilla's weight and the average weight of all
     */
    @Override
    public Double deltaWeight() {
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
            double targetWeight = avgChinchillaWeight;

            // calculate delta weight and return absolute value
            double deltaWeight = this.currentWeight - targetWeight;
            return Math.abs(deltaWeight);
        }



    /**
     Returns the full name of the person, including their title and credentials if available.
     @return A String representing the person's full name, including their title and credentials if available.
     */
    @Override
    public String getName() {
        String fullName = this.name;
        if (this.title != null) {
            fullName = this.title + " " + fullName;
        }
        if (this.credentials != null) {
            fullName = fullName + ", " + this.credentials;
        }
        return fullName;
    }

    /**
     * Determines whether the current pet's name has a title and a credential
     *
     * @return true if the name is both titled and credentialed.
     */
    @Override
    public Boolean honorablyTitled() {
        boolean hasTitle = this.title != null;
        boolean hasCredential = this.credentials != null && !this.credentials.isEmpty();
        return hasTitle && hasCredential;
    }


    /**

     Bestows a new title upon the pet, updating its name if it does not already have a title.
     @param title The new title to bestow upon the pet.

     */
    @Override
    public void bestowTitle(String title) {
        // Check if pet already has a title
        if (this.title != null) {
            // Replace the old title with the new one
            this.title = title;
        } else {
            // Add the new title to the name
            this.name = title + " " + this.name;
            this.title = title;
        }
    }

    /**
     * Takes a credential and adds it to the end of the adoptable pet's name after a ","
     * If the name already has a credential, add this credential after the current one(s) space separated
     *
     * @param credential the credential to add
     */
    @Override
    public void bestowCredential(String credential) {
        if (this.credentials == null) {
            this.credentials = new ArrayList<>();
        }
        // Add the new credential to the list of credentials
        this.credentials.add(credential);
        // Update the pet's name with the new credential
        StringBuilder nameBuilder = new StringBuilder(this.name);
        if (this.credentials.size() == 1) {
            // If this is the first credential, add it after the name
            nameBuilder.append(", ");
            nameBuilder.append(credential);
        } else {
            // Otherwise, add it after the existing credential(s)
            nameBuilder.append(" ");
            nameBuilder.append(credential);
        }
        this.name = nameBuilder.toString();
    }

}
