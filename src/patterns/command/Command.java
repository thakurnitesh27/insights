package patterns.command;

public abstract class Command {

    Onable onable;

    public Command(Onable onable) {
        this.onable = onable;
    }

    public abstract void execute(State state);

    public void undo()
    {
        if(onable.getCurrentState()==State.ON)
            onable.setState(State.OFF);
        else
            onable.setState(State.ON);

        System.out.println("State changed to-"+onable.getCurrentState().name());
    }
}
