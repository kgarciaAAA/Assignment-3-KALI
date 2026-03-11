package main;

public class GameResultView {
    /**
     * Prints what each player chose and the round outcome.
     * @param result 0 = draw, 1 = human wins, 2 = computer wins
     */
    public void printRoundResult(Move humanMove, Move computerMove, int result) {
        System.out.println("You chose " + humanMove + ":");
        System.out.println(humanMove.getArt());

        System.out.println("Computer chose " + computerMove + ":");
        System.out.println(computerMove.getArt());

        switch (result) {
            case 0 -> System.out.println("Draw!");
            case 1 -> System.out.println("You Win!");
            case 2 -> System.out.println("Computer Wins!");
        }
    }

    /**
     * Prints the overall winner of the game.
     * @param gameResult 0 = draw, 1 = human wins, 2 = computer wins
     */
    public void printGameResult(int gameResult) {
        switch(gameResult) {
            case 0: 
                System.out.println("**** Draw. Nobody wins. ****");
                break;
            case 1:
                System.out.println("**** Human Wins the Game ****");
                break;
            case 2:
                System.out.println("**** Computer Wins the Game ****");
                break;
        }
    }
}
