/**
 * Represents a custom exception that is thrown when a candidate is voted for more than once.
 */
public class MoreThanOnceException extends Exception {
    /**
     * Constructs a MoreThanOnceException with the given candidate name.
     *
     * @param candidate The name of the candidate that has been voted for more than once.
     */
    public MoreThanOnceException(String candidate) {
        super("Candidate " + candidate + " has been voted for more than once.");
    }
}
