package ooconcepts.innerclasses;

public class ContainingClass {
    String name = "ContainingClass";
    String uniqueName = "UniqueContainingClass";

    void doContainingClassInstanceStuff() {
        name += "Augmented";
        System.out.println("ContainingClassStuff");
    }

    public class InnerClass {
        String name = "InnerClass";

        public void printNames() {
            System.out.println(name);
            System.out.println(ContainingClass.this.name);
            // We can directly reference the containing class's instance variables
            System.out.println(uniqueName);

            // And we can call the containing class's instance methods
            doContainingClassInstanceStuff();
            System.out.println(ContainingClass.this.name);
        }
    }

    InnerClass createInnerClass() {
        return new InnerClass();
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
        String name = "StaticInnerClass";

        public void printNames() {
            System.out.println(name);

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
        //ContainingClass.InnerClass innerClass3 = new ContainingClass.InnerClass();

        ContainingClass.MultipleInheritanceInnerClass multipleInheritanceInnerClass = containingClass.new MultipleInheritanceInnerClass();
        multipleInheritanceInnerClass.printNames();

        ContainingClass.StaticInnerClass staticInnerClass = new ContainingClass.StaticInnerClass();
        staticInnerClass.printNames();

        ContainingClass.StaticInnerClass staticInnerClass1 = ContainingClass.createNewStaticInnerClass();
        staticInnerClass1.printNames();
    }
}
