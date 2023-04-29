import java.util.HashMap;
import java.util.Optional;

/**
 * An interface for a modular "vote for 3 people" strategy
 */
public interface I3VoteStrategy {

    Optional<String> calculateWinner(HashMap<String, Votes> votes);
}
