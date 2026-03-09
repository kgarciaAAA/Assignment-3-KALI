public class Game {
    private final HumanPlayer humanPlayer;
    private final ComputerPlayer computerPlayer;
    private final ScoreBoard scoreboard;
    private final GameLogic gameLogic;
    private final int numberOfRounds;

    /**
     * Initializes a 1v1 game between a human player and a computer player.
     * @param numberOfRounds number of rounds to play
     */
    public Game(int numberOfRounds) {
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new ComputerPlayer();
        this.scoreboard = new ScoreBoard();
        this.gameLogic = new GameLogic();
        this.numberOfRounds = numberOfRounds;
    }

    public void startGame() {
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.print("Round " + round + " - ");
            Move humanMove = humanPlayer.getPlayerMove();
            Move computerMove = computerPlayer.getPlayerMove();

            int result = gameLogic.determineWinner(humanMove, computerMove);
            printRoundResult(humanMove, computerMove, result);
            scoreboard.recordResult(result);
            scoreboard.displayScore();

        }
    }

    /**
     * Prints what each player chose and the round outcome.
     * @param result 0 = draw, 1 = human wins, 2 = computer wins
     */
    private void printRoundResult(Move humanMove, Move computerMove, int result) {
        System.out.printf("You chose %s. The computer chose %s. ", humanMove, computerMove);

        switch (result) {
            case 0:
                System.out.println("Draw!");
                break;
            case 1:
                System.out.println("You Win!");
                break;
            case 2:
                System.out.println("Computer Wins!");
                break;
            default:
                throw new IllegalArgumentException("Invalid result: " + result);
        }
    }
}
