package examples.command;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControlTest {

    @Test
    void testRemoteControl() {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light("Living Room");
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        remoteControl.setCommand(0, lightOn, lightOff);

        TV tv = new TV("Living Room");
//        remoteControl.setCommand(1, () -> tv.on(), () -> tv.off());
        remoteControl.setCommand(1, tv::on, tv::off);
        remoteControl.pushOnButton(0);
        remoteControl.pushOnButton(1);
    }

    @Test
    void testMethodReference() {
        Light light = new Light("Living Room");

        List<SimpleCommand> commands = List.of(
                new LightOnCommand(light),
                new LightOffCommand(light),
                light::on);

        commands.forEach(SimpleCommand::execute);
    }
}