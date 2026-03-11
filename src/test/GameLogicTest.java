package test;

import main.GameLogic;
import main.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    private final GameLogic logic = new GameLogic();

    @Test
    void testDraws() {
        Assertions.assertEquals(0, logic.roundWinner(Move.ROCK, Move.ROCK));
        Assertions.assertEquals(0, logic.roundWinner(Move.PAPER, Move.PAPER));
        Assertions.assertEquals(0, logic.roundWinner(Move.SCISSORS, Move.SCISSORS));
    }

    @Test
    void testHumanWinsCases() {
        Assertions.assertEquals(1, logic.roundWinner(Move.ROCK, Move.SCISSORS));
        Assertions.assertEquals(1, logic.roundWinner(Move.PAPER, Move.ROCK));
        Assertions.assertEquals(1, logic.roundWinner(Move.SCISSORS, Move.PAPER));
    }

    @Test
    void testComputerWinsCases() {
        Assertions.assertEquals(2, logic.roundWinner(Move.ROCK, Move.PAPER));
        Assertions.assertEquals(2, logic.roundWinner(Move.PAPER, Move.SCISSORS));
        Assertions.assertEquals(2, logic.roundWinner(Move.SCISSORS, Move.ROCK));
    }
}
