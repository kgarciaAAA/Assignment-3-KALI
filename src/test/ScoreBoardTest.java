package test;

import main.ScoreBoard;
import main.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    void testRecordResultCountsCorrectly() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.HUMAN_WIN); // human win
        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.DRAW); // draw
        sb.recordResult(Result.HUMAN_WIN); // human win

        // Winner should be human (2 vs 1)
        Assertions.assertEquals(Result.HUMAN_WIN, sb.getGameWinner());
    }

    @Test
    void testGameWinnerDraw() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.HUMAN_WIN); // human win
        sb.recordResult(Result.COMPUTER_WIN); // computer win

        Assertions.assertEquals(Result.DRAW, sb.getGameWinner());
    }

    
    @Test
    void testGameWinnerComputerWins() {
        ScoreBoard sb = new ScoreBoard();

        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.COMPUTER_WIN); // computer win
        sb.recordResult(Result.DRAW); // draw

        Assertions.assertEquals(Result.COMPUTER_WIN, sb.getGameWinner());
    }
}
