package patterns.command2;

enum State{ON, OFF}
public abstract class Command {

    State currentState;

    public Command(State currentState)
    {
        this.currentState=currentState;
    }

    public Command()
    {
        this(State.OFF);
    }

    public  void execute(State state)
    {
        currentState=state;
    }
}
