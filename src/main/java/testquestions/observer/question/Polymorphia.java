package testquestions.observer.question;

import java.util.List;

public class Polymorphia implements EventIssuingObservable {
    @Override
    public void attach(EventObserver observer) {

    }

    @Override
    public void attach(EventObserver observer, EventType type) {

    }

    @Override
    public void attach(EventObserver observer, List<EventType> types) {

    }

    @Override
    public void detach(EventObserver observer) {

    }
}
