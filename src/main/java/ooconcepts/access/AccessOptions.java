package ooconcepts.access;

public class AccessOptions {

    private void helperMethod() {
        System.out.println("This is a private helper method.");
    }

    public void publicMethod() {
        System.out.println("This is a public method.");
        helperMethod();
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method. All subclasses can access it.");
    }

    void packagePrivateMethod() {
        System.out.println("This is a package-private method. All classes in the same package can access it.");
    }
}
