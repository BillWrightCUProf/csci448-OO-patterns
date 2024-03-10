package examples.decorator;

public abstract class BeverageDecorator extends Beverage {
    Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }

    public Double getCost() {
        return beverage.getCost() + cost;
    }

    public Size getSize() {
        return beverage.size;
    }
}
