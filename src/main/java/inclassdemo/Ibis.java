package inclassdemo;

public class Ibis extends Animal {
    public static double DEFAULT_WEIGHT_IN_KILOGRAMS = 0.5;
    public Ibis(String name, String foodType, String location) {
        super(name, foodType, location);
    }

    @Override
    void setDefaultWeight() {
        this.weightInKilograms = DEFAULT_WEIGHT_IN_KILOGRAMS;
    }

    @Override
    public void makeNoise() {
        System.out.println("Tweet");
    }
}
