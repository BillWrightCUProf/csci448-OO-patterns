package examples.decorator;

public class Mocha extends BeverageDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
        description = "Mocha";
        cost = 0.20;
    }

    public Double getCost() {
        Double totalCost = beverage.getCost();
        if (getSize() == Size.TALL) {
            return totalCost + cost;
        } else if (getSize() == Size.GRANDE) {
            return totalCost + cost + 0.10;
        } else {
            return totalCost + cost + 0.20;
        }
    }

}
