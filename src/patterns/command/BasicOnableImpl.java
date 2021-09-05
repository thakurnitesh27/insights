package patterns.command;

public class BasicOnableImpl implements Onable {

    State currentState;

    public BasicOnableImpl(State currentState) {
        this.currentState = currentState;
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
