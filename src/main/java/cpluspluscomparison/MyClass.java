package cpluspluscomparison;

public class MyClass {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static void main(String[] args) {
        {
            MyClass myClass = new MyClass("Heap");
            System.out.println(myClass.getName());
        }
        System.out.println("Exiting");
    }
}
