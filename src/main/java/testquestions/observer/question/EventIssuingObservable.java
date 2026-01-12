package testquestions.observer.question;

import java.util.List;

public interface EventIssuingObservable {
    void attach(EventObserver observer);
    void attach(EventObserver observer, EventType type);
    void attach(EventObserver observer, List<EventType> types);
    void detach(EventObserver observer);
}
