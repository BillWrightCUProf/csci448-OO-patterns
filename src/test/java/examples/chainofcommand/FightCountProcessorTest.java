package examples.chainofcommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightCountProcessorTest {

    @Test
    void process() {
        FightCountProcessor processor = new FightCountProcessor();
        assertEquals(0, processor.fightCount);

        processor.process(Event.FIGHT);
        assertEquals(1, processor.fightCount);

        processor.process(Event.MOVE);
        assertEquals(1, processor.fightCount);

        processor.process(Event.FIGHT);
        processor.process(Event.FIGHT);
        assertEquals(3, processor.fightCount);
    }

}