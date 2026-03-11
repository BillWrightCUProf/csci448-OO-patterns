package examples.factory;

public class PizzaStoreWithInjection {
    private Pizza pizza;

    public PizzaStoreWithInjection(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = this.pizza;

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
