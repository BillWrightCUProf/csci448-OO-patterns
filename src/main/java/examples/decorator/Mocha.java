package examples.decorator;

import java.util.HashMap;
import java.util.Map;

public class Mocha extends BeverageDecorator {

    private static Map<Size, Double> ADDITIONAL_COSTS;

    static {
        ADDITIONAL_COSTS = new HashMap<>();
        ADDITIONAL_COSTS.put(Size.TALL, 0.00);
        ADDITIONAL_COSTS.put(Size.GRANDE, 0.10);
        ADDITIONAL_COSTS.put(Size.VENTI, 0.20);
    }

    public Mocha(Beverage beverage) {
        super(beverage);
        description = "Mocha";
        cost = 0.20;
    }

    public Double getCost() {
        Double totalCost = beverage.getCost() + cost;
        if (getSize() == Size.VENTI) {
            totalCost += 0.20;
        }
        if (getSize() == Size.GRANDE) {
            totalCost += 0.10;
        }
        return totalCost;
    }

    public Double getCost2() {
        Double totalCost = beverage.getCost() + cost;
        switch (getSize()) {
            case GRANDE -> totalCost += 0.20;
            case VENTI -> totalCost += 0.10;
        }
        return totalCost;
    }

    public Double getCost3() {
        return beverage.getCost() + ADDITIONAL_COSTS.get(getSize());
    }

}
