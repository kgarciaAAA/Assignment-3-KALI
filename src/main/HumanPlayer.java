package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Asks user choice their next move as an int. The method validates the user input,
     * and if validated, returns their next move.
     * @return the human player's selected move as a main.Move enum value
     */
    @Override
    public Move getPlayerMove() {
        while (true) {
            try {
            System.out.print("Choose (1=rock, 2=paper, 3=scissors): ");
            int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        return Move.ROCK;
                    }
                    case 2 -> {
                        return Move.PAPER;
                    }
                    case 3 -> {
                        return Move.SCISSORS;
                    }
                    default -> {
                        scanner.nextLine();
                        System.out.println("Invalid Choice. Try Again...");
                    }
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid Choice. Try Again...");
            }
        }
    }
}
