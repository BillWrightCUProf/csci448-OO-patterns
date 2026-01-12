package testquestions.observer.question;

public class AudibleObserver implements EventObserver {
    AudiblePlayer player;

    public AudibleObserver(AudiblePlayer player) {
        this.player = player;
    }

    @Override
    public void update(EventType eventType, String message) {
        player.say(message);
    }
}