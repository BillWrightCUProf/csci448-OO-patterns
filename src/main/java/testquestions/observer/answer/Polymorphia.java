package testquestions.observer.answer;

import testquestions.observer.question.EventIssuingObservable;
import testquestions.observer.question.EventObserver;
import testquestions.observer.question.EventType;

import java.util.List;

public class Polymorphia implements MazeObservable, EventIssuingObservable {
    @Override
    public String getJsonDescription() {
        return "";
    }

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
