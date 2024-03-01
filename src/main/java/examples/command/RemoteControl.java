package examples.command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<Integer, SimpleCommand> buttonToOnCommand = new HashMap<>();
    private Map<Integer, SimpleCommand> buttonToOffCommand = new HashMap<>();
    public RemoteControl() {
    }
    public void setCommand(int i, SimpleCommand onCommand, SimpleCommand offCommand) {
        buttonToOnCommand.put(i, onCommand);
        buttonToOffCommand.put(i, offCommand);
    }

    public void pushOnButton(int i) {
        buttonToOnCommand.get(i).execute();
    }
}
