package examples.decorator;

public abstract class DecoratedBeverage extends Beverage {
    Beverage beverage;

    public DecoratedBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    protected void setSize(Size size) {
        beverage.setSize(size);
    }

    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }

    public Double getCost() {
        return beverage.getCost() + cost;
    }

}
