package cpluspluscomparison;

public class Mammal extends Animal {
    private boolean laysEggs;

    public Mammal(String name, boolean laysEggs) {
        super(name);
        this.laysEggs = laysEggs;
    }

    @Override
    public String getName() {
        return "Mammal: " + super.getName();
    }
}
