package testquestions.iclicker;

import java.util.Random;

public class HowManyVariablesCharacter {
    public static final int DEFAULT_INITIAL_HEALTH = 10;
    private String name;
    private int health;

    public HowManyVariablesCharacter(String name) {
        this.name = name;
        this.health = HowManyVariablesCharacter.DEFAULT_INITIAL_HEALTH;

        boolean doubleUp = (new Random().nextBoolean());
        if (doubleUp) {
            this.health *= 2;
            System.out.println(name + " is lucky and starts with double health: " + this.health);
        }
    }
}
