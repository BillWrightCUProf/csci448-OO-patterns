package ooconcepts.innerclasses;

public class ContainingClass {
    private String name = "ContainingClass";
    private String uniqueName = "UniqueContainingClass";
    private Integer id = 123;

    public ContainingClass() {
        System.out.println("ContainingClass constructor");
        id = 246;
    }

    void doContainingClassInstanceStuff() {
        name += "Augmented";
        System.out.println("ContainingClassStuff");
    }

    InnerClass createInnerClass() {
        return new InnerClass();
    }
    StaticInnerClass createStaticInnerClass() { return new StaticInnerClass(); }

    class InnerClass {
        String name = "InnerClass";

        public void setContainingClassPrivateName(String name) {
            // This line is only allowed for non
            ContainingClass.this.name = name;
        }

        public void printNames() {
            System.out.println(name);
            System.out.println(ContainingClass.this.name);
            // We can directly reference the containing class's instance variables
            System.out.println(uniqueName);

            System.out.println(id);

            // And we can call the containing class's instance methods
            doContainingClassInstanceStuff();
            System.out.println(ContainingClass.this.name);
        }
    }



    public class AnotherInnerClass2 extends InnerClass {
        String name = "AnotherInnerClass";
        Integer id = 456;
    }

    public class MultipleInheritanceInnerClass extends SeparateClass {
        String name = "MultipleInheritanceInnerClass";
        public void printNames() {
            System.out.println(name);
            System.out.println(ContainingClass.this.name);

            // We can directly reference the containing class's instance variables
            System.out.println(uniqueName);

            // And our superclass' instance variables and methods
            System.out.println(id);
            doSeparateClassStuff();

            // And we can call the containing class's instance methods
            doContainingClassInstanceStuff();
            System.out.println(ContainingClass.this.name);
        }
    }

    public static class StaticInnerClass {
        private ContainingClass containingClass = new ContainingClass();

        String name = "StaticInnerClass";

        public void printNames() {
            System.out.println(name);

            containingClass.name = "Setting name from StaticInnerClass";

            System.out.println(containingClass.name);
            // We cannot do this
            // System.out.println(ContainingClass.this.name);
        }
    }

    public static StaticInnerClass createNewStaticInnerClass() {
        return new StaticInnerClass();
    }

    public static void main(String[] args) {
        ContainingClass containingClass = new ContainingClass();
        ContainingClass.InnerClass innerClass = containingClass.new InnerClass();
        innerClass.printNames();
        ContainingClass.InnerClass innerClass2 = containingClass.createInnerClass();
        innerClass2.name = "InnerClass2";
        innerClass2.printNames();

        // We cannot do this:
//        ContainingClass.InnerClass innerClass3 = new ContainingClass.InnerClass();

        ContainingClass.MultipleInheritanceInnerClass multipleInheritanceInnerClass = containingClass.new MultipleInheritanceInnerClass();
        multipleInheritanceInnerClass.printNames();

        ContainingClass.StaticInnerClass staticInnerClass = new ContainingClass.StaticInnerClass();
        staticInnerClass.printNames();

        ContainingClass.StaticInnerClass staticInnerClass1 = ContainingClass.createNewStaticInnerClass();
        staticInnerClass1.printNames();
    }
}
