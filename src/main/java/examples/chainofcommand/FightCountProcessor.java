package examples.chainofcommand;

public class FightCountProcessor extends Processor {
    int fightCount = 0;

    public FightCountProcessor() {
        super();
    }

    public FightCountProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(Event event) {
        if (event == Event.FIGHT) {
            fightCount++;
        }
        super.process(event);
    }
}
