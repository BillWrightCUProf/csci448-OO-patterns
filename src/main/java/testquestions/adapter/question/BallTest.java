package testquestions.adapter.question;

//import org.junit.Test;

import java.util.List;

public class BallTest {

//    @Test
    public void testBalls() {
        List<Ball> balls = List.of(new Baseball(), new CricketBall(), new Softball());

        for (Ball ball : balls) {
            ball.pitch();
        }
        new Frisbee().fling();
        new Die().roll();
    }
}
