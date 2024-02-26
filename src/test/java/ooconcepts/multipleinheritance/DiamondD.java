package ooconcepts.multipleinheritance;

public class DiamondD extends DerivedB implements InterfaceC {
    public int dNumber = 50;
    public String dName = "DiamondD";

    @Override
    public void myMethod() {
        System.out.println(dName);
        System.out.println(super.id);
        System.out.println(super.name);
    }
}
