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

    public Pizza orderPizza2(String type) {

        Pizza pizza = switch (type) {
            case "cheese" -> factory.createCheesePizza();
            case "greek" -> factory.createGreekPizza();
            default -> factory.createPepperoniPizza();
        };

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
