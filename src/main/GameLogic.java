package main;

public class GameLogic {

    /**
     * Determines the winner of a round between two players.
     * @param humanMove the human player's move
     * @param computerMove the computer player's move
     * @return 0 for draw, 1 if human wins, 2 if computer wins
     */
    public int roundWinner(Move humanMove, Move computerMove) {
        if (humanMove == computerMove)
            return 0;
        // A series of if statements to determine if the human wins. 
        boolean humanWins = (humanMove == Move.ROCK && computerMove == Move.SCISSORS) 
                            || (humanMove == Move.PAPER && computerMove == Move.ROCK)
                            || (humanMove == Move.SCISSORS && computerMove == Move.PAPER);

        return humanWins ? 1 : 2;
    }

    
}
