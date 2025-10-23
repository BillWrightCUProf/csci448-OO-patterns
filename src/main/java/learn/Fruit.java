package learn;

public class Fruit implements Edible, Digestible {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Eating " + name);
    }

    @Override
    public void digest() {
        System.out.println("Digesting " + name);
    }

    @Override
    public void defaultMethod() {
        System.out.println("Default method in Fruit class.");
    }

    @Override
    public String toString() {
        return "Fruit{name='" + name + "'}";
    }
}
