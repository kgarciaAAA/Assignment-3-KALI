public enum Move {
    ROCK("""
        _______
    ---'   ____)
          (_____)
          (_____)
          (____)
    ---.__(___)
    """),

    PAPER("""
        _______
    ---'   ____)____
              ______)
              _______)
             _______)
    ---.__________)
    """),

    SCISSORS("""
        _______
    ---'   ____)____
              ______)
           __________)
          (____)
    ---.__(___)
    """);

    private final String art;

    Move(String art) {
        this.art = art;
    }

    public String getArt() {
        return art;
    }

    @Override
    public String toString() {
        String n = name();
        return n.charAt(0) + n.substring(1).toLowerCase();
    }
}
