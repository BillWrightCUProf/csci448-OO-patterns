package examples.chainofcommand;

public class Processor {
    private final Processor nextProcessor;

    public Processor() {
        this.nextProcessor = null;
    }

    public Processor(Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void process(Event event) {
        if (nextProcessor != null) {
            nextProcessor.process(event);
        }
    }
}
