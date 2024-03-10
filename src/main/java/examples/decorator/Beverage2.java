package examples.decorator;

public class Beverage2 {
    public enum Size { TALL, GRANDE, VENTI }
    Size size = Size.TALL;

    List<Condiments> condiments = new ArrayList<Condiments>();

    void addCondiment(Condiments condiment) {
        condiments.add(condiment);
    }

    String getDescription() {
        String desc = "";
        for (Condiments condiment : condiments) {
            desc += condiment.getDescription() + ", ";
        }
        return desc;
    }

    Double getCost() {
        Double totalCost = 0.0;
        for (Condiments condiment : condiments) {
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

    public Double getCost() {
        return cost;
    }
    public String getDescription() {
        return description;
    }
}
