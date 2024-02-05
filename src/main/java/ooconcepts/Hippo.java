package ooconcepts;

public class Hippo extends Animal {

    private Boolean isSubmerged = false;

    public Hippo(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    public String toString() {
        return super.toString() + " Submerged: " + isSubmerged;
    }

    public void eat() {
        isSubmerged = true;
        super.eat();
    }
}
