package examples.factory;

import org.junit.jupiter.api.Test;

class PizzaStoreWithFactoryTest {

    @Test
    void orderPizza() {
        SimplePizzaFactory factory = new SimplePizzaFactory();

        PizzaStoreWithFactory pizzaStore = new PizzaStoreWithFactory(factory);
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("We ordered a " + pizza + "\n");
    }

}