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


    /**
     * Begins and manages the entire game session
     */
    public void startGame() {
        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.print("Round " + round + " - ");
            Move humanMove = humanPlayer.getPlayerMove();
            Move computerMove = computerPlayer.getPlayerMove();

            int result = gameLogic.roundWinner(humanMove, computerMove);
            printRoundResult(humanMove, computerMove, result);
            scoreboard.recordResult(result);
            scoreboard.displayScore();

        }
        int gameResult = scoreboard.getGameWinner();
        printGameResult(gameResult);
    }

    /**
     * Prints what each player chose and the round outcome.
     * @param result 0 = draw, 1 = human wins, 2 = computer wins
     */
    private void printRoundResult(Move humanMove, Move computerMove, int result) {
        System.out.println("You chose " + humanMove + ":");
        System.out.println(humanMove.getArt());

        System.out.println("Computer chose " + computerMove + ":");
        System.out.println(computerMove.getArt());

        switch (result) {
            case 0 -> System.out.println("Draw!");
            case 1 -> System.out.println("You Win!");
            case 2 -> System.out.println("Computer Wins!");
        }
    }

    /**
     * Prints the overall winner of the game.
     * @param gameResult 0 = draw, 1 = human wins, 2 = computer wins
     */
    private void printGameResult(int gameResult) {
        switch(gameResult) {
            case 0: 
                System.out.println("**** Draw. Nobody wins. ****");
                break;
            case 1:
                System.out.println("**** Human Wins the Game ****");
                break;
            case 2:
                System.out.println("**** Computer Wins the Game ****");
                break;
        }
    }
}
