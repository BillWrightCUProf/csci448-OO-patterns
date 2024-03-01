package examples.command;

public class LightOnCommand implements Command {
    Light light;  //reference to the command Receiver

    // constructor – sets the specific light to command
    public LightOnCommand(Light light) {
        this.light = light;
    }

    // override for execute with specifically what action the light needs to do
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
