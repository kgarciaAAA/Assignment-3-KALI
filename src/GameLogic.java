import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class GameLogic {

    /**
     * Determines the winner(s) of a round based on all players' moves.
     * Draw if everyone threw the same move or all 3 options are present.
     * @param playerMoves array of moves made by each player
     * @return array of winner indexes (1-indexed), or {0} for a draw
     */
    public Integer[] determineWinner(Move[] playerMoves) {
        // Check if there are exactly 2 distinct moves
        Set<Move> distinctMoves = new HashSet<>();
        for (Move move : playerMoves)
            distinctMoves.add(move);

        if (distinctMoves.size() != 2)
            return new Integer[]{0};

        Move winningMove = getWinningMove(distinctMoves);

        ArrayList<Integer> winners = new ArrayList<>();
        for (int i = 0; i < playerMoves.length; i++)
            if (playerMoves[i] == winningMove)
                winners.add(i + 1); // +1 because the first index is the draw score

        return winners.toArray(new Integer[winners.size()]);
    }

    /**
     * Given exactly two distinct moves, returns the one that beats the other.
     */
    private Move getWinningMove(Set<Move> moves) {
        if (moves.contains(Move.ROCK) && moves.contains(Move.SCISSORS))
            return Move.ROCK;
        else if (moves.contains(Move.PAPER) && moves.contains(Move.ROCK))
            return Move.PAPER;
        else
            return Move.SCISSORS;
    }
}
