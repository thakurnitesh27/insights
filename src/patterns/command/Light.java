package patterns.command;

public class Light implements Onable {

    State currentState;

    public Light(State currentState)
    {
        this.currentState=currentState;
    }
    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public void setState(State state) {
        currentState=state;

    }
}
