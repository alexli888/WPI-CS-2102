/**
 * Represents a custom exception that is thrown when a candidate is not nominated.
 */
public class CandidateNotNominatedException extends Exception {

    private String candidate;

    /**
     * Constructs a CandidateNotNominatedException with the given candidate name.
     *
     * @param candidate The name of the candidate that is not nominated.
     */
    public CandidateNotNominatedException(String candidate) {
        super("Candidate " + candidate + " has not been nominated.");
        this.candidate = candidate;
    }
    /**
     * Gets the name of the candidate that is not nominated.
     *
     * @return The name of the candidate.
     */
    public String getCandidate() {
        return candidate;
    }
}
