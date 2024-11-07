package examples.template;

public class CoffeeTemplate extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
