package refactoring.dotsandboxes;

public class Side {
    private Player owner = Player.NONE;
    private int row, col;
    private Orientation orientation;

    public Side(int row, int col, Orientation orientation) {
        this.row = row;
        this.col = col;
        this.orientation = orientation;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public boolean isVertical() {
        return orientation == Orientation.VERTICAL;
    }

    public boolean isHorizontal() {
        return orientation == Orientation.HORIZONTAL;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public boolean unowned() {
        return owner == Player.NONE;
    }

    @Override
    public String toString() {
        String representation = "Side(" + row + ", " + col + ", " + orientation + ") owned by ";
        representation += switch (owner) {
            case NONE -> " ";
            case HUMAN -> "H";
            case COMPUTER -> "C";
        };
        return representation;
    }

    public boolean isComputerOwned() {
        return owner == Player.COMPUTER;
    }

    public void clear() {
        owner = Player.NONE;
    }
}
