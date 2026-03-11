package test;

import static org.junit.jupiter.api.Assertions.*;

import main.ScoreBoard;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    void testRecordResultCountsCorrectly() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(1); // human win
        sb.recordResult(2); // computer win
        sb.recordResult(0); // draw
        sb.recordResult(1); // human win

        // Winner should be human (2 vs 1)
        assertEquals(1, sb.getGameWinner());
    }

    @Test
    void testGameWinnerDraw() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(1);
        sb.recordResult(2);

        assertEquals(0, sb.getGameWinner());
    }

    @Test
    void testGameWinnerComputerWins() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(2);
        sb.recordResult(2);
        sb.recordResult(0);

        assertEquals(2, sb.getGameWinner());
    }
}
