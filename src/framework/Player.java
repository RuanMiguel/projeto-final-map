package framework;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name, int score) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
