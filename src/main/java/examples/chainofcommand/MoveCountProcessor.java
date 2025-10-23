package examples.chainofcommand;

public class MoveCountProcessor extends Processor {
    int moveCount = 0;

    public MoveCountProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(Event event) {
        if (event == Event.MOVE) {
            moveCount++;
        }
        super.process(event);
    }
}
