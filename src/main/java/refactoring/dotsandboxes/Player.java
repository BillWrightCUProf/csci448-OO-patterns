package refactoring.dotsandboxes;

public enum Player {
    NONE, HUMAN, COMPUTER;

    @Override
    public String toString() {
        return switch (this) {
            case NONE -> " ";
            case HUMAN -> "H";
            case COMPUTER -> "C";
        };
    }
}

