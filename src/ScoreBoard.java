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
            default:
                throw new IllegalArgumentException("Invalid result: " + result);
        }
    }

    public void displayScore() {
        System.out.printf("Score: Human: %s. Computer: %s. Draws= %s. \n", humanScore, computerScore, draws);
    }
}
