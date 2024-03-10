package examples.uml;

public class DiceGame {
    public Die die1 = new Die();
    public Die die2 = new Die();

    static public void main(String[] args) {
        DiceGame game = new DiceGame();
        game.play();
    }

    public void play() {
        die1.roll();
        die1.getFaceValue();
        die2.roll();
        die2.getFaceValue();
    }
}
