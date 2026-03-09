public class RockPaperScissors {
    //TODO: rework structure of the main method to be more modular and reusable, for changes in UI
    public static void main(String[] args) {
        // Create a game with 1 human player and 1 computer player, playing 20 rounds
        Game game = new Game(1, 1, 20);
        game.startGame();
    }
}