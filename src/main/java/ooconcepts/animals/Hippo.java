package ooconcepts.animals;

public class Hippo extends Animal {

    private Boolean isSubmerged = false;

    public Hippo(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    public String toString() {
        return super.toString() + " Submerged: " + isSubmerged;
    }

    public void eat() {
        submerge();
        super.eat();
    }

    public void submerge() {
        isSubmerged = true;
        System.out.println("I'm underwater!");
    }
}
