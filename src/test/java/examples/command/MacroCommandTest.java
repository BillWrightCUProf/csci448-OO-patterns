package examples.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MacroCommandTest {

    @Test
    void testMacroCommand() {
        Light light = new Light("rec room");
        TV tv = new TV("rec room");
        Command lightOn = new LightOnCommand(light);
        Command tvOn = new TVOnCommand(tv);
        Command lightOff = new LightOffCommand(light);
        Command tvOff = new TVOffCommand(tv);
        Command[] partyOn = {lightOn, tvOn};
        Command[] partyOff = {lightOff, tvOff, lightOff};
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);
        partyOnMacro.execute();
        partyOffMacro.execute();
    }

}