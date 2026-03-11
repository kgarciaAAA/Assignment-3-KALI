package test;

import main.GameLogic;
import main.Move;
import main.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    private final GameLogic logic = new GameLogic();

    @Test
    void testDraws() {
        Assertions.assertEquals(Result.DRAW, logic.roundWinner(Move.ROCK, Move.ROCK));
        Assertions.assertEquals(Result.DRAW, logic.roundWinner(Move.PAPER, Move.PAPER));
        Assertions.assertEquals(Result.DRAW, logic.roundWinner(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    void testHumanWinsCases() {
        Assertions.assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.ROCK, Move.SCISSORS));
        Assertions.assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.PAPER, Move.ROCK));
        Assertions.assertEquals(Result.HUMAN_WIN, logic.roundWinner(Move.SCISSORS, Move.PAPER));
    }

    @Test
    void testComputerWinsCases() {
        Assertions.assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.ROCK, Move.PAPER));
        Assertions.assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.PAPER, Move.SCISSORS));
        Assertions.assertEquals(Result.COMPUTER_WIN, logic.roundWinner(Move.SCISSORS, Move.ROCK));
    }
}
