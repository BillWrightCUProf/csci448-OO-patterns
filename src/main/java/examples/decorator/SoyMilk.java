package examples.decorator;

public class SoyMilk extends Condiment {
    @Override
    public String getDescription() {
        return "Soy";
    }

    @Override
    public Double getCost() {
        return 0.25;
    }
}
