package examples.factory;

public class ChicagoPizzaStore extends PizzaStoreWithFactoryMethod {

    public Pizza createPizza(String item) {
        return new ChicagoCheesePizza();
    }

}
