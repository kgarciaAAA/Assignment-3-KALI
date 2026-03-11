package test;
import main.ComputerPlayer;
import main.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class ComputerPlayerTest {
    @Test
    public void testRandomness(){
        ComputerPlayer computer = new ComputerPlayer();
        Set<Move> previousMoves = new HashSet<>();

        int attempts = 0;
        int maxAttempts = 1000;

        while (previousMoves.size() < 3 && attempts < maxAttempts){
            Move move = computer.getPlayerMove();
            previousMoves.add(move);
            attempts++;
        }

        assertTrue(previousMoves.contains(Move.ROCK), "Rock was not thrown");
        assertTrue(previousMoves.contains(Move.PAPER), "Paper was not thrown");
        assertTrue(previousMoves.contains(Move.SCISSORS), "Scissors was not thrown");
    }
}
