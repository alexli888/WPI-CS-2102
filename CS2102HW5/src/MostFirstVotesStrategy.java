import java.util.HashMap;
import java.util.Optional;

/**
 * Represents a vote counting strategy that determines the winner based on the most first votes.
 */
public class MostFirstVotesStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on the most first votes.
     *
     * @param votes A HashMap containing the votes for each candidate.
     * @return An Optional containing the name of the winner, or empty if no winner is determined.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        int maxFirstVotes = 0;
        String winner = null;
        boolean tie = false;
        for (String candidate : votes.keySet()) {
            int firstVotes = votes.get(candidate).getFirstVotes();
            if (firstVotes > maxFirstVotes) {
                maxFirstVotes = firstVotes;
                winner = candidate;
                tie = false;
            } else if (firstVotes == maxFirstVotes) {
                tie = true;
            }
        }
        return tie ? Optional.empty() : Optional.ofNullable(winner);
    }
}
