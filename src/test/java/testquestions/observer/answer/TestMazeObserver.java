package testquestions.observer.answer;

import org.junit.jupiter.api.Test;
import testquestions.observer.question.EventType;

import static org.junit.jupiter.api.Assertions.*;

class TestMazeObserver {

    @Test
    public void testMazeObserver() {
        Polymorphia game = new Polymorphia();
        MazeViewer mazeViewer = new MazeViewer(game);
        // Polymorphia will only send TurnEnded events to the viewer
        game.attach(mazeViewer, EventType.TurnEnded);
    }

}