package examples.factory;

public class PizzaStore {
//    Pizza orderPizza1(String type) {
//        Pizza pizza;
//        if (type.equals("cheese")) {
//            pizza = new CheesePizza();
//        } else if (type.equals("greek")) {
//            pizza = new GreekPizza();
//        } else if (type.equals("pepperoni")) {
//            pizza = new PepperoniPizza();
//        }
//
//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//
//        return pizza;
//    }

    Pizza orderPizza2(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else {
            pizza = new PepperoniPizza();
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    Pizza orderPizza(String type) {
        Pizza pizza = switch (type) {
            case "cheese" -> new CheesePizza();
            case "greek" -> new GreekPizza();
            default -> new PepperoniPizza();
        };

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
