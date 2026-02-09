package ooconcepts.overriding;

public class Subclass extends BaseClass {
    String name;
    int age;

    public Subclass(String name, int age) {
        super(name, age);
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }
}
