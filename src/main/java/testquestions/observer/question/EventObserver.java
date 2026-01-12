package testquestions.observer.question;

public interface EventObserver {
    void update(EventType eventType, String message);
}
