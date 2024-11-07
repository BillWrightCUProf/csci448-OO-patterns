package examples.template;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    // Will not compile because boilWater is final in CaffeineBeverage
//    public void boilWater() {
//        System.out.println("Boiling water");
//    }

    private void pourInCup() {
        System.out.println("Pouring into a MUG");
        boilWater();
    }

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    boolean customerWantsCondiments() {
        return getUserInput().startsWith("y");
    }

    private String getUserInput() {
        String answer;

        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        answer = System.console().readLine();
        if (answer == null) {
            return "no";
        }
        return answer.toLowerCase();
    }
}
