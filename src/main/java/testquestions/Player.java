package testquestions;

public class Player {
    static int instanceCount = 0;

    private String name;
    private int score;

    Player(String name) {
        this.name = name;
        this.score = 0;
        instanceCount++;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }

    public void addScore(int points) {
        score += points;
    }
}
