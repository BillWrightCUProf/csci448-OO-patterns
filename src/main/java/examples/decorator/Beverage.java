package examples.decorator;

public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI }

    Size size;
    Double cost;
    String description = "Unknown Beverage";

    Beverage() {
    }

    public Beverage(Size size) {
        setSize(size);
    }

    public Size getSize() {
        return size;
    }
    protected void setSize(Size size) {
        this.size = size;
    }

    public Double getCost() {
        return cost;
    }
    public String getDescription() {
        return description;
    }
}
