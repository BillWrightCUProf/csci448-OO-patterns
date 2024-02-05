package ooconcepts;

public class TurboEngine extends Engine {

    private final Integer powerBoost = 50;

    @Override
    public Integer getHorsepower() {
        return super.getHorsepower() + powerBoost;
    }
}
