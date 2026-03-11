package examples.template.pizza;

public abstract class PizzaStore {

    private Pizza createPizza(String type) {
        return new Pizza();
    }

    protected abstract void prepare(Pizza pizza);
    protected abstract void bake(Pizza pizza);
    protected abstract void cut(Pizza pizza);
    protected abstract void box(Pizza pizza);

    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        prepare(pizza);
        bake(pizza);
        cut(pizza);
        box(pizza);

        return pizza;
    }
}
