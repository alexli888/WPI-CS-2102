import java.util.Scanner;

public class VotingMachine {
    private ElectionData eData; // ElectionData field
    private Scanner scanner; // Scanner field for IO

    // Constructor
    public VotingMachine() {
        this.eData = new ElectionData(new MostFirstVotesStrategy()); // Initial strategy set to MostFirstVotesStrategy
        this.scanner = new Scanner(System.in); // Initialize Scanner for IO
    }

    // Method to nominate a candidate
    public void nominate() {
        System.out.print("Enter the name to nominate: ");
        String name = scanner.nextLine().trim();
        try {
            eData.nominateCandidate(name);
            System.out.println(name + " has been nominated successfully.");
        } catch (AlreadyNominatedException e) {
            System.out.println("Error: " + name + " is already nominated.");
        }
    }

    // Method to cast/submit a vote
    public void vote() {
        System.out.println("Enter your first, second, and third choice candidates (one at a time): ");
        String firstChoice = scanner.nextLine().trim();
        String secondChoice = scanner.nextLine().trim();
        String thirdChoice = scanner.nextLine().trim();
        try {
            eData.submitVote(firstChoice, secondChoice, thirdChoice);
            System.out.println("Vote cast successfully.");
        } catch (CandidateNotNominatedException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.print("Would you like to nominate the candidate? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                nominate();
            }
        } catch (MoreThanOnceException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to change winner strategy
    public void changeStrategy() {
        System.out.println("Which strategy would you like to use? most [f]irst votes or most [a]greeable? ");
        String choice = scanner.nextLine().trim().toLowerCase();
        switch (choice) {
            case "f":
                eData.setStrategy(new MostFirstVotesStrategy());
                System.out.println("Most First Votes strategy set successfully.");
                break;
            case "a":
                eData.setStrategy(new MostAgreeableStrategy());
                System.out.println("Most Agreeable strategy set successfully.");
                break;
            default:
                System.out.println("Error: Invalid choice. Please try again.");
                break;
        }
    }

    // Method to see who won/ who is winner
    public void seeWinner() {
        if (eData!=null ) {
            System.out.println("Winner: " + eData.calculateWinner());
        } else {
            System.out.println("No clear winner under the current strategy.");
        }
    }

    // Method to run the voting machine
    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit: ");
            String choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "n":
                    nominate();
                    break;
                case "v":
                    vote();
                    break;
                case "s":
                    changeStrategy();
                    break;
                case "w":
                    seeWinner();
                    break;
                case "q":
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please try again.");
                    break;
            }
        }


        scanner.close(); // Closes the Scanner
    }
}
