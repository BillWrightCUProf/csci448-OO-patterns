package examples.decorator;

public class WhippedCream extends DecoratedBeverage {
    public WhippedCream(Beverage beverage) {
        super(beverage);
        description = "Whipped Cream";
        cost = 0.50;
    }
}
