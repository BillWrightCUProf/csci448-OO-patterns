package testquestions.adapter.answer;

import testquestions.adapter.question.Ball;
import testquestions.adapter.question.Frisbee;

public class FrisbeeAdapter implements Ball {
    private final Frisbee frisbee;

    public FrisbeeAdapter(Frisbee frisbee) {
        this.frisbee = frisbee;
    }

    @Override
    public void pitch() {
        this.frisbee.fling();
    }
}
