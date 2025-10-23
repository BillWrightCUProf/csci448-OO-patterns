package ooconcepts.reflection;

public class PrivateDataClass {
    private final String name;
    private final int age;

    public PrivateDataClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PrivateDataClass{" + "name=" + name + ", age=" + age + '}';
    }
}
