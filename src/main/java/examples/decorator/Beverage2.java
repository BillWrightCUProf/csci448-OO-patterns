package examples.decorator;

import java.util.ArrayList;
import java.util.List;

public class Beverage2 {
    public enum Size { TALL, GRANDE, VENTI }
    Size size = Size.TALL;

    List<Condiment> condiments = new ArrayList<Condiment>();

    void addCondiment(Condiment condiment) {
        condiments.add(condiment);
    }

    String getDescription() {
        String desc = "";
        for (Condiment condiment : condiments) {
            desc += condiment.getDescription() + ", ";
        }
        return desc;
    }

    Double getCost() {
        Double totalCost = 0.0;
        for (Condiment condiment : condiments) {
            totalCost += condiment.getCost();
        }
        return totalCost;
    }
    String description = "Unknown Beverage";
    Double cost;

    public Beverage2() {
    }

    public Beverage2(Size size) {
        this.size = size;
    }

}
