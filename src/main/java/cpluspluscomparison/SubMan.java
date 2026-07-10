package cpluspluscomparison;

public class SubMan extends SuperMan {
    private int subId;
    public SubMan() {
        super();
        this.subId = 2;
    }

    @Override
    public String whoAmI() {
        return "I am SubMan with ID: " + subId;
    }
}
