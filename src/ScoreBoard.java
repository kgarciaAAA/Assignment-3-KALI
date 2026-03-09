public class ScoreBoard {
    protected int[] scores;

    /**
     * Initializes the score board with the number of players.
     * The first index is the draw score, and the rest are the scores for each player.
     * @param numberOfPlayers total number of players in the game + draw slot
     */
    public ScoreBoard(int numberOfPlayers) {
        this.scores = new int[numberOfPlayers];
    }

    /**
     * Records the result of a round. If winners[0] is 0, it's a draw.
     * Otherwise, each value in winners is a 1-indexed player whose score is incremented.
     * @param winners array of winner indexes (1-indexed), or {0} for a draw
     */
    public void recordResult(Integer[] winners) {
        if (winners[0] == 0) {
            scores[0]++;
            return;
        } else {
            for (int winner : winners)
                scores[winner]++;
        }
    }

    /**
     * Displays the current score. Formatted for 1 human vs 1 computer.
     */
    public void displayScore() {
        System.out.println("Score: Human:" + scores[1] + " Computer:" + scores[2] + " Draws=" + scores[0]);
    }
}
