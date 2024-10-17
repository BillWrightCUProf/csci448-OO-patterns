package examples.adapter;

public class WildTurkeyAdapterMI extends WildTurkey implements Duck {
    public void quack() {
        gobble();
    }

    public void fly() {
        for (int i = 0; i < 5; i++) {
            super.fly();
        }
    }
}
