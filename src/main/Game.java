package main;

public class Game {
    private final HumanPlayer humanPlayer;
    private final ComputerPlayer computerPlayer;
    private final ScoreBoard scoreboard;
    private final GameLogic gameLogic;
    private final GameResultView gameResultView;
    private final int numberOfRounds;

    /**
     * Initializes a 1v1 game between a human player and a computer player.
     * @param numberOfRounds number of rounds to play
     */
    public Game(int numberOfRounds) {
        this.humanPlayer = new HumanPlayer();
        this.computerPlayer = new ComputerPlayer();
        this.scoreboard = new ScoreBoard();
        this.gameResultView = new GameResultView();
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
            gameResultView.printRoundResult(humanMove, computerMove, result);
            scoreboard.recordResult(result);
            scoreboard.displayScore();

        }
        int gameResult = scoreboard.getGameWinner();
        gameResultView.printGameResult(gameResult);
    }

}
