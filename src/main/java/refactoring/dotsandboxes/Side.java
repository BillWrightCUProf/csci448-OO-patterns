package refactoring.dotsandboxes;

public class Side {
    Player owner = Player.NONE;

    public boolean unowned() {
        return owner == Player.NONE;
    }
}
