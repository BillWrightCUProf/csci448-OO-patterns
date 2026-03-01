package examples.factory;

public abstract class PizzaStoreWithFactoryMethod {

    protected abstract Pizza createPizza(String item);

    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
