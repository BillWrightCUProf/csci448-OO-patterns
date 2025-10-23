package examples.chainofcommand;

public class Polymorphia {
    Processor initialProcessor;

    public Polymorphia() {
        initialProcessor = new MoveCountProcessor(
                new DeathCountProcessor(
                        new FightCountProcessor()
                ));
    }

    public void processEvent(Event event) {
        initialProcessor.process(event);
    }
}
