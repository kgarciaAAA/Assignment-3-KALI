public enum Move {
    ROCK, PAPER, SCISSORS;

    public void printMove() {
        System.out.print(name().charAt(0) + name().substring(1).toLowerCase());
    }
}
