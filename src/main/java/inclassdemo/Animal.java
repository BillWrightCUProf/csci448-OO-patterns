package inclassdemo;

public abstract class Animal implements Comparable<Animal> {
    String name;
    String foodType;
    String location;
    Double weightInKilograms;

    public Animal(String name, String foodType, String location) {
        this.name = name;
        this.foodType = foodType;
        this.location = location;
        setDefaultWeight();
    }

    abstract void setDefaultWeight();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", foodType='" + foodType + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("I'm eating");
    }

    public void makeNoise() {
        System.out.println("Making noise");
    }

    public void roam() {
        System.out.println("Roaming");
    }

    public void doAllThree() {
        eat();
        makeNoise();
        roam();;
    }

//    @Override
//    public int compareTo(Animal other) {
//        return Math.toIntExact(Math.round(this.weightInKilograms - other.weightInKilograms));
//    }

    @Override
    public int compareTo(Animal other) {
        return this.weightInKilograms.compareTo(other.weightInKilograms);
    }
}
