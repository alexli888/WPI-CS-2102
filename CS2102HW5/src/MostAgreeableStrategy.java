import java.util.HashMap;
import java.util.Optional;

/**
 * Represents a vote counting strategy that determines the winner based on the most total votes.
 */
public class MostAgreeableStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on the most total votes.
     *
     * @param votes A HashMap containing the votes for each candidate.
     * @return An Optional containing the name of the winner, or empty if no winner is determined.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String winner = null;
        int maxVotes = -1;
        for (String candidate : votes.keySet()) {
            int totalVotes = votes.get(candidate).getFirstVotes()
                    + votes.get(candidate).getSecondVotes() + votes.get(candidate).getThirdVotes();
            if (totalVotes > maxVotes) {
                maxVotes = totalVotes;
                winner = candidate;
            }
        }
        return Optional.ofNullable(winner);
    }
}
