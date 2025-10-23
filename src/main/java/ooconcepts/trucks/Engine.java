package ooconcepts.trucks;

public class Engine {

    private final Integer horsepower = 300;

    public Integer getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return "Engine [horsepower=" + getHorsepower() + "]";
    }
}
