package examples.decorator;

public class Espresso extends Beverage {

    public Espresso(Size size) {
        super(size);
        description = "Espresso";
        cost = 1.99;
    }

}
