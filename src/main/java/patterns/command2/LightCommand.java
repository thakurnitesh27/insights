package patterns.command2;

public class LightCommand extends Command {

    Light light;
    public LightCommand(Light light)
    {
     this.light=light;
    }
    @Override
    public void execute(State state) {
        if(state==State.OFF)
            light.setOff();
        else
            light.setOn();
        super.execute(state);
    }
}
