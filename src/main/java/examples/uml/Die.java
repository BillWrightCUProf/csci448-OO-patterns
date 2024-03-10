package examples.uml;

import java.util.Random;

public class Die {
    private final Random random = new Random();
    private Integer faceValue;

    public void roll() {
        // roll the die
        faceValue = random.nextInt(6) + 1;
    }

    public Integer getFaceValue() {
        return faceValue;
    }
}
