package patterns.command;

public class TvCommand extends Command {


    public TvCommand(Onable onable) {
        super(onable);
    }

    @Override
    public void execute(State state) {

        System.out.println("Switching Tv-"+ state.name());
        onable.setState(state);
    }
}
