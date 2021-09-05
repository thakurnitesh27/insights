package patterns.command2;

public class RemoteControl
{
    Command[] onCommand;
    Command[] offCommand;



    RemoteControl(Command[] onCommand, Command[] offCommand)
    {
        this.offCommand=offCommand;
        this.onCommand=onCommand;
    }

    public void executeOn(int i)
    {
        onCommand[i].execute(State.ON);
    }

    public void executeOff(int i)
    {
        offCommand[i].execute(State.OFF);
    }
}
