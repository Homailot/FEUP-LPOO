import java.util.Stack;

public class IcecreamMachine {
    Icecream icecream;
    Stack<Command> commandStack;

    IcecreamMachine(Icecream icecream) {
        this.icecream = icecream;
        commandStack = new Stack<>();
    }

    public IcecreamMachine executeCommand(Command command) {
        command.execute(this.icecream);
        commandStack.add(command);

        return this;
    }

    public void undoLastCommand() {
        if(commandStack.empty()) return;

        Command last_command = commandStack.pop();
        last_command.undo(icecream);
    }
}
