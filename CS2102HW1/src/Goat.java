import java.util.ArrayList;
public class Goat extends Adoptable{

    public Goat(String name, Double age, Double currentWeight, Coord whereabouts) {
        super(name, age, currentWeight, whereabouts);
    }
    /**
     * Calculates the difference between this adoptable pet-to-be's current weight and the target weight for it's species
     *
     * @return the magnitude (non-negative) value of the difference
     */
    @Override
    public Double deltaWeight() {
        Double targetWeight = Math.round((55000 + ((age / 12.0) * 1000)) * 100.0) / 100.0;
        Double roundedWeight = Math.round(currentWeight * 100.0) / 100.0;
        return Math.abs(roundedWeight - targetWeight);
    }

    /**
     * Constructs a name from the adoptable pet-to-be's base name and their title and credentials
     *
     * @return the full name of the pet in "title name, cred" format.
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
     * Takes a title and adds it to the adoptable pet's name
     * If the adoptable already has a title, it should replace the old title with a new one
     *
     * @param title the title to bestow
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
        nameBuilder.append(", ");
        nameBuilder.append(credential);
        for (String existingCredential : this.credentials) {
            nameBuilder.append(" ");
            nameBuilder.append(existingCredential);
        }
        this.name = nameBuilder.toString();
    }

}
