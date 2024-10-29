package examples.strategy;

public class Swimmer {
    Stroke behavior;

    Swimmer(Stroke behavior) {
        this.behavior = behavior;
    }

    public void swim() {
        switch (behavior) {
            case BACK -> System.out.println("Swim on your back");
            case SIDE -> System.out.println("Swim on your side");
            case BREAST -> System.out.println("Swim using breaststroke");
            case BUTTERFLY -> System.out.println("Swim with both arms at once");
            case FREESTYLE -> System.out.println("Swim by alternating arms");
            case DOG_PADDLE -> System.out.println("Swim in the upright position");
        }
    }
}
