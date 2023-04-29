import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;
public class Examples {
 // write 6 more tests that fail on buggy imp
    @Test
    public void testOneVote() {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

        try {
            electionData.nominateCandidate("Candidate1");
            electionData.nominateCandidate("Candidate2");
            electionData.nominateCandidate("Candidate3");
            electionData.submitVote("Candidate1", "Candidate2", "Candidate3");
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.of("Candidate1"), electionData.calculateWinner());
    }


    @Test
    public void testOneVoteAgain() {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

        try {
            electionData.nominateCandidate("Gompeii");
            electionData.nominateCandidate("Duck");
            electionData.nominateCandidate("Goose");
            electionData.submitVote("Gompeii", "Duck", "Goose");
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.of("Gompeii"), electionData.calculateWinner());
    }


    @Test(expected = AlreadyNominatedException.class)
    public void testCandidateAlreadyNominated() throws AlreadyNominatedException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

        electionData.nominateCandidate("Goose");
        electionData.nominateCandidate("Goose");
        fail("Did not throw exception properly");
    }

    @Test(expected = AlreadyNominatedException.class)
    public void testAlreadyNominatedException() throws AlreadyNominatedException {
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());

        electionData.nominateCandidate("Duck");
        electionData.nominateCandidate("Duck"); // Expect AlreadyNominatedException
    }

    @Test
    public void testCalculateWinnerWithNoClearMajority() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        // Nominate candidates
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Candidate1");
        electionData.nominateCandidate("Candidate2");
        electionData.nominateCandidate("Candidate3");
        electionData.nominateCandidate("Candidate4");

        // Submit votes with no clear majority
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");
        electionData.submitVote("Candidate2", "Candidate3", "Candidate4");
        electionData.submitVote("Candidate3", "Candidate4", "Candidate1");
        electionData.submitVote("Candidate4", "Candidate1", "Candidate2");

        // Assert that winner is not determined due to lack of clear majority
        Optional<String> winner = electionData.calculateWinner();
        assertFalse(winner.isPresent());
    }

    @Test
    public void testCalculateWinnerWithClearMajority() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        // Nominate candidates
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Candidate1");
        electionData.nominateCandidate("Candidate2");
        electionData.nominateCandidate("Candidate3");

        // Submit votes with clear majority
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");

        // Assert that winner is determined with clear majority
        Optional<String> winner = electionData.calculateWinner();
        assertTrue(winner.isPresent());
        assertEquals("Candidate1", winner.get());
    }

    @Test
    public void testMostAgreeableStrategy() {
        ElectionData electionData = new ElectionData(new MostAgreeableStrategy());

        try {
            electionData.nominateCandidate("Cat");
            electionData.nominateCandidate("Hippo");
            electionData.nominateCandidate("Giraffe");
            electionData.submitVote("Cat", "Hippo", "Giraffe");
            electionData.submitVote("Hippo", "Giraffe", "Cat");
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.of("Hippo"), electionData.calculateWinner());
    }


    @Test
    public void testSubmitVoteWithValidVotes() throws AlreadyNominatedException, CandidateNotNominatedException, MoreThanOnceException {
        // Nominate candidates
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Candidate1");
        electionData.nominateCandidate("Candidate2");
        electionData.nominateCandidate("Candidate3");

        // Submit valid votes
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");
        electionData.submitVote("Candidate2", "Candidate3", "Candidate1");
        electionData.submitVote("Candidate3", "Candidate1", "Candidate2");

        // Assert that votes are submitted without any exceptions
        // No assertion is made on the return value, as it is not relevant to this test case
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testSubmitVoteCandidateNotNominatedException() throws CandidateNotNominatedException, MoreThanOnceException, AlreadyNominatedException {
        // Arrange
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Candidate1");
        electionData.nominateCandidate("Candidate2");
        // Candidate3 is not nominated

        // Act
        electionData.submitVote("Candidate1", "Candidate2", "Candidate3");

        // Assert
        // Expecting a CandidateNotNominatedException to be thrown, as Candidate3 is not nominated
    }

    @Test(expected = MoreThanOnceException.class)
    public void testSubmitVoteMoreThanOnceException() throws CandidateNotNominatedException, MoreThanOnceException, AlreadyNominatedException {
        // Arrange
        ElectionData electionData = new ElectionData(new MostFirstVotesStrategy());
        electionData.nominateCandidate("Candidate1");
        electionData.nominateCandidate("Candidate2");

        // Act
        electionData.submitVote("Candidate1", "Candidate1", "Candidate2");

        // Assert
        // Expecting a MoreThanOnceException to be thrown, as Candidate1 is voted for more than once
    }
}
