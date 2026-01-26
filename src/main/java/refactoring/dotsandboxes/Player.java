package refactoring.dotsandboxes;

public enum Player {
    NONE, PLAYER, COMPUTER;

    @Override
    public String toString() {
        return switch (this) {
            case NONE -> " ";
            case PLAYER -> "P";
            case COMPUTER -> "C";
        };
    }
}

