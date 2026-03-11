package examples.template.pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected void prepare(Pizza pizza) {

    }

    @Override
    public void bake(Pizza pizza) {
        // Do special Chicago baking;
    }

    @Override
    protected void cut(Pizza pizza) {

    }

    @Override
    protected void box(Pizza pizza) {

    }

//    @Override
//    public Pizza orderPizza(String type) {
//        // Do something different
//        return super.orderPizza(type);
//    }

}
