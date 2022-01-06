package patterns.command;

public class SimpleRemoteControl {
    //7 slots with on and off each.

    Command[] onButtons;
    Command [] offButtons;

    Command lastCommand;

    public SimpleRemoteControl(Command[] onButtons, Command[] offButtons) {
        this.onButtons = onButtons;
        this.offButtons = offButtons;
    }

    //For testing only 2 slots are defined.
    public void setOn(int i)
    {
        (lastCommand=  onButtons[i]).execute(State.ON);
    }

    public void setOff(int i)
    {
        ( lastCommand=offButtons[i]).execute(State.OFF);
    }

    public void undo()
    {
        if(lastCommand==null)
        {
            System.out.println("No undo operation performed.");
            return;
        }
        lastCommand.undo();
    }
}
