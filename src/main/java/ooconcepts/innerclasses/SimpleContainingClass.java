package ooconcepts.innerclasses;

public class SimpleContainingClass {
    private String name;

    private SimpleContainingClass() {}

    public String getName() {
        return name;
    }

    public static class StaticInnerClass {
        private SimpleContainingClass simpleContainingClass = new SimpleContainingClass();

        void setName(String name) {
            simpleContainingClass.name = name;
        }

        SimpleContainingClass getSimpleContainingClass() {
            return simpleContainingClass;
        }
    }
}
