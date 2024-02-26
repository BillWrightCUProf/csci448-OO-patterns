package inclassdemo;

public class Hippo extends Animal {
    public static double DEFAULT_WEIGHT_IN_KILOGRAMS = 1500.0;
    Boolean isSubmerged = false;

    public Hippo(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    void setDefaultWeight() {
        this.weightInKilograms = DEFAULT_WEIGHT_IN_KILOGRAMS;
    }

    void submerge() {
        isSubmerged = true;
    }
}
