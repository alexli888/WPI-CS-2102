/**
 * Represents a custom exception that is thrown when a candidate is already nominated.
 */
public class AlreadyNominatedException extends Exception {
    /**
     * Constructs an AlreadyNominatedException with the given candidate name.
     *
     * @param candidate The name of the candidate that is already nominated.
     */
    public AlreadyNominatedException(String candidate) {
        super("Candidate " + candidate + " has already been nominated.");
    }
}
