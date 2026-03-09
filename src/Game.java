public class Game {
    protected int numberOfPlayers;
    protected Player[] players;
    protected ScoreBoard scoreboard;
    protected GameLogic gameLogic;
    protected int numberOfRounds;

    /**
     * Initializes the game with the number of human players, computer players, and number of rounds.
     * Players array has index 0 reserved (null) so player indices align with scoreboard indices.
     * @param numberOfHumanPlayers number of human players
     * @param numberOfComputerPlayers number of computer players
     * @param numberOfRounds number of rounds
     */
    public Game(int numberOfHumanPlayers, int numberOfComputerPlayers, int numberOfRounds) {
        this.numberOfPlayers = numberOfHumanPlayers + numberOfComputerPlayers;
        this.players = new Player[numberOfPlayers + 1];
        initializePlayers(numberOfHumanPlayers, numberOfComputerPlayers);
        this.scoreboard = new ScoreBoard(numberOfPlayers + 1);
        this.gameLogic = new GameLogic();
        this.numberOfRounds = numberOfRounds;
    }

    /**
     * Fills players[1..n] with HumanPlayers first, then ComputerPlayers.
     * Index 0 is left null to align with the scoreboard's draw slot.
     * 
     * @param numberOfHumanPlayers number of human players
     * @param numberOfComputerPlayers number of computer players
     */
    private void initializePlayers(int numberOfHumanPlayers, int numberOfComputerPlayers) {
        players[0] = null;
        for (int i = 1; i <= numberOfHumanPlayers; i++)
            players[i] = new HumanPlayer();

        for (int i = numberOfHumanPlayers + 1; i <= numberOfPlayers; i++)
            players[i] = new ComputerPlayer();
    }

    public void startGame() {
        for (int round = 1; round <= numberOfRounds; round++) {
            Move[] moves = new Move[numberOfPlayers];

            System.out.print("Round " + round + " - ");
            for (int i = 1; i <= numberOfPlayers; i++)
              moves[i - 1] = players[i].getPlayerMove();

            Integer[] winners = gameLogic.determineWinner(moves);
            printRoundResult(moves, winners);
            scoreboard.recordResult(winners);
            scoreboard.displayScore();
            System.out.println();
        }
    }

    /**
     * Prints what each player chose and the round outcome.
     * Currently formatted for 1 human vs 1 computer.
     */
    private void printRoundResult(Move[] moves, Integer[] winners) {
        System.out.printf("You chose %s. The computer chose %s. ", moves[0], moves[1]);
        

        if (winners[0] == 0)
            System.out.println("Draw!");
        else if (winners[0] == 1)
            System.out.println("You Win!");
        else
            System.out.println("Computer Wins!");
    }
}
