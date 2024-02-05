package ooconcepts;

public class Ford extends Truck {

    public Engine getEngine() {
        System.out.println("In get engine...");
        return super.getEngine();
    }
}
