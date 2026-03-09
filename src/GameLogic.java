import java.util.ArrayList;
import java.util.List;
public class GameLogic {
    // Use to determine the winner(s) for a RPS (Rock_Paper_Scissors) round

    public Integer[] determineWinner(Move[] moves) {
        boolean hasRock = false;
        boolean hasPaper = false;
        boolean hasScissors = false;

        for (Move m: moves) {
            if (m == Move.ROCK) hasRock = true;
            else if (m == Move.PAPER) hasPaper = true;
            else if (m == Move.SCISSORS) hasScissors = true;
        }

        int distinct = (hasRock ? 1 : 0) + (hasPaper ? 1 : 0) + (hasScissors ? 1 : 0);

        // Draw if everyone chose the same move, or if all three moves appear
        if (distinct <= 1 || distinct == 3) {
            return new Integer[] {0};
        }

        // Exactly two moves are present to determine which move wins
        Move winningMove;
        if (hasRock && hasScissors) {
            winningMove = Move.ROCK;        // Rock beats Scissors
        } else if (hasScissors && hasPaper) {
            winningMove = Move.SCISSORS;    // Scissors beats Paper
        } else {
            winningMove = Move.PAPER;       // Paper beats Rock
        }

        // Collect all players (1-indexed) who played the winning move
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] == winningMove) {
                winners.add(i + 1); // convert 0-indexed moves[] to 1-indexed player id
            }
        }

        // Safety fallback (shouldn't happen)
        if (winners.isEmpty()) {
            return new Integer[]{0};
        }

        return winners.toArray(new Integer[0]);
    }
}
