package examples.template.mazedweller;

import examples.template.Adventurer;

public class Coward extends Adventurer {
    @Override
    public void fight() {
        System.out.println("Running away from the dragon...");
    }
}
