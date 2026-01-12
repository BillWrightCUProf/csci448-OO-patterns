package testquestions.adapter.answer;

//import org.junit.Test;
import testquestions.adapter.question.*;

import java.util.List;

public class BallTest {

//    @Test
    public void testBalls() {
        List<Ball> balls = List.of(
                new Baseball(),
                new CricketBall(),
                new Softball(),
                new FrisbeeAdapter(new Frisbee()),
                new DieAdapter(new Die()));
        for (Ball ball : balls) {
            ball.pitch();
        }
    }
}
