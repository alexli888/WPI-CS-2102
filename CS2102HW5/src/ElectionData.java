import java.util.HashMap;
import java.util.Set;
import java.util.Optional;

/**
 * Represents the data and operations for an election.
 */
public class ElectionData {

    private HashMap<String, Votes> votes;
    private I3VoteStrategy strategy;

    /**
     * Constructs an ElectionData object with the specified vote counting strategy.
     *
     * @param strategy The vote counting strategy to be used for calculating the winner.
     */
    public ElectionData(I3VoteStrategy strategy) {
        this.votes = new HashMap<>();
        this.strategy = strategy;
    }

    /**
     * Sets the vote counting strategy to be used for calculating the winner.
     *
     * @param strategy The vote counting strategy to be set.
     */
    public void setStrategy(I3VoteStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Retrieves the set of candidates who have been nominated.
     *
     * @return The set of candidates who have been nominated.
     */
    public Set<String> getCandidates() {
        return votes.keySet();
    }

    /**
     * Nominates a candidate for the election.
     *
     * @param person The name of the candidate to be nominated.
     * @throws AlreadyNominatedException If the candidate has already been nominated.
     */
    public void nominateCandidate(String person) throws AlreadyNominatedException {
        if (votes.containsKey(person)) {
            throw new AlreadyNominatedException(person + " has already been nominated.");
        } else {
            votes.put(person, new Votes(0, 0, 0));
        }
    }

    /**
     * Submits a vote with three ranked choices for the election.
     *
     * @param first The name of the candidate for the first choice.
     * @param second The name of the candidate for the second choice.
     * @param third The name of the candidate for the third choice.
     * @throws CandidateNotNominatedException If at least one of the candidates in the vote has not been nominated.
     * @throws MoreThanOnceException If the same candidate is voted for more than once in the same vote.
     */
    public void submitVote(String first, String second, String third) throws CandidateNotNominatedException,
            MoreThanOnceException {
        if (!votes.containsKey(first) || !votes.containsKey(second) || !votes.containsKey(third)) {
            throw new CandidateNotNominatedException(
                    third);
        } else if (first.equals(second) || first.equals(third) || second.equals(third)) {
            throw new MoreThanOnceException("The same candidate cannot be voted for more than once in the same vote.");
        } else {
            votes.get(first).voteFirst();
            votes.get(second).voteSecond();
            votes.get(third).voteThird();
        }
    }

    /**
     * Calculates the winner of the election using the current vote counting strategy.
     *
     * @return An Optional containing the name of the winner, or empty if no winner is determined.
     */
    public Optional<String> calculateWinner() {
        return strategy.calculateWinner(votes);
    }

}
