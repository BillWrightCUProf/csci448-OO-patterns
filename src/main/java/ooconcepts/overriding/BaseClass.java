package ooconcepts.overriding;

public class BaseClass {
    String name;
    int age;

    public BaseClass(String name, int age) {
        this.name = "Super " + name;
        this.age = age + 25;
    }

    public int getAge() {
        return age;
    }
}
