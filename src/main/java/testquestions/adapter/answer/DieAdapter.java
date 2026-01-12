package testquestions.adapter.answer;

import testquestions.adapter.question.Ball;
import testquestions.adapter.question.Die;

public class DieAdapter implements Ball {
    private final Die die;

    public DieAdapter(Die die) {
        this.die = die;
    }

    @Override
    public void pitch() {
        this.die.roll();
    }
}
