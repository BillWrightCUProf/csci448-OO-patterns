package refactoring.dotsandboxes;

import java.util.List;

public class Box {
    Side left;
    Side right;
    Side top;
    Side bottom;
    Player owner = Player.NONE;

    public int getCol() {
        return left.getCol();
    }

    public int getRow() {
        return top.getRow();
    }

    public Player getOwner() {
        return owner;
    }

    public List<Side> getOwnedSides() {
        return List.of(left, right, top, bottom).stream()
                .filter(side -> !side.unowned())
                .toList();
    }

    public boolean isComplete() {
        return getOwnedSides().size() == 4;
    }

    public boolean isOwned() {
        return owner != Player.NONE;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
