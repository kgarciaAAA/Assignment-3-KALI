public enum Move {
    ROCK, PAPER, SCISSORS;

    /**
     * Displays the enum values
     */
    @Override public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
