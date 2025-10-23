package ooconcepts;

public class HotWaterBottle implements BedWarmer {
    private int temperature;
    private int capacity;

    public HotWaterBottle(int temperature, int capacity) {
        this.temperature = temperature;
        this.capacity = capacity;
    }

    @Override
    public int temperatureInCelsius() {
        return temperature;
    }

    @Override
    public int capacityInMinutes() {
        return capacity;
    }
}
