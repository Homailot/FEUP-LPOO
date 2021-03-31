
public class AddScoopCommand extends Command{
    Flavor flavor;
    Boolean executed;

    AddScoopCommand(Flavor flavor) {
        this.flavor = flavor;
        executed = false;
    }

    @Override
    public void execute(Icecream icecream) {
        icecream.addScoop(flavor);
        executed = true;
    }

    @Override
    public void undo(Icecream icecream) {
        if(executed) {
            icecream.removeScoop(flavor);
        }
    }
}
