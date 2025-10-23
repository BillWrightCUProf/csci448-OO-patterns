package examples.chainofcommand;

public class DeathCountProcessor extends Processor {
    int deathCount = 0;

    public DeathCountProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void process(Event event) {
        if (event == Event.DEATH) {
            deathCount++;
        }
        super.process(event);
    }
}
