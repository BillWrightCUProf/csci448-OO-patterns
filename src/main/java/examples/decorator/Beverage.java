package examples.decorator;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI }
    Size size = Size.TALL;
    String description = "Unknown Beverage";
    Double cost;

    public Beverage() {
    }

    public Beverage(Size size) {
        this.size = size;
    }

    public Double getCost() {
        return cost;
    }
    public String getDescription() {
        return description;
    }

}
