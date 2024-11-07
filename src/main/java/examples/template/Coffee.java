package examples.template;

public class Coffee {
    public void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }
}
