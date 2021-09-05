package patterns.command;

enum State{
    ON,OFF
}
public interface Onable  {

    public State getCurrentState();

    public void setState(State state);
}
