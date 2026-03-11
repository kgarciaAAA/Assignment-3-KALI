package main;

public class ScoreBoard {
    private int humanScore;
    private int computerScore;
    private int draws;

    /**
     * Records the result of a round.
     * @param result 0 = draw, 1 = human wins, 2 = computer wins
     */
    public void recordResult(int result) {
        switch (result) {
            case 0:
                draws++;
                break;
            case 1:
                humanScore++;
                break;
            case 2:
                computerScore++;
                break;
        }
    }

    /**
     * Displays the current score for human wins, computer wins, and draws.
     */
    public void displayScore() {
        System.out.printf("Score: Human: %s. Computer: %s. Draws: %s. \n\n", humanScore, computerScore, draws);
    }

    /**
     * Determines the winner of the game based comparisons between scores.
     * @return 0 = draw, 1 = human wins, 2 = computer wins
     */
    public int getGameWinner() {
        if (humanScore > computerScore) {
            return 1;
        } else if (humanScore < computerScore) {
            return 2;
        } else {
            return 0;
        }
    }
}
