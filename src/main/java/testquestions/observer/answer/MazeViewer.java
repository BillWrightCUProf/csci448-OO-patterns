package testquestions.observer.answer;

import testquestions.observer.question.EventObserver;
import testquestions.observer.question.EventType;

public class MazeViewer implements EventObserver {
    MazeObservable game;

    public MazeViewer(MazeObservable game) {
        this.game = game;
    }

    public void show(String jsonMazeDescription) {
    }

    @Override
    public void update(EventType event, String message) {
        show(game.getJsonDescription());
    }

}
