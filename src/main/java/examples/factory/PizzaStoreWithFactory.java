package examples.factory;

public class PizzaStoreWithFactory {
    SimplePizzaFactory factory;

    public PizzaStoreWithFactory(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
