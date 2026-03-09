import java.util.Random;

public class ComputerPlayer extends Player{
    private final Random randomNum = new Random();

    /**
     * Uses the random library to generate a random number from 0-2,
     * and returns a Move based on the number selected.
     * @return the computer's randomly selected move
     */
    @Override
    public Move getPlayerMove() {
        int computerMove = randomNum.nextInt(3);

        return switch (computerMove) {
            case 0 -> Move.ROCK;
            case 1 -> Move.PAPER;
            default -> Move.SCISSORS;
        };
    }
}
