package patterns.command;

public class CommandExecutorTest {
/*
Here RemoteControl just needs to hold the Command for each button press. It is not aware about what happens internally when any button is pressed. It is just
allowed to call execute() method of command. Command is of different types which is stored in abstract form in RemoteController.

This is the Command pattern where it encapsulates the request as an object.

Onable is added to prohibit from creating on and off class for same item-tv or light.
 */
    public static void main(String[] args) {


        Command lightONCommand=new LightCommand(new BasicOnableImpl(State.ON));
        Command lightOFFCommand=new LightCommand(new BasicOnableImpl(State.OFF));


        Command TvONCommand=new TvCommand(new BasicOnableImpl(State.ON));
        Command TvOFFCommand=new TvCommand(new BasicOnableImpl(State.OFF));

        Command [] onCommand =new Command[]{lightONCommand,TvONCommand};
        Command [] offCommand =new Command[]{lightOFFCommand,TvOFFCommand};

        SimpleRemoteControl simpleRemoteControl=new SimpleRemoteControl(onCommand,offCommand);


        simpleRemoteControl.undo();
        simpleRemoteControl.setOn(0);
        simpleRemoteControl.setOff(0);
        simpleRemoteControl.undo();
        simpleRemoteControl.undo();


        simpleRemoteControl.setOn(1);
        simpleRemoteControl.setOff(1);

        simpleRemoteControl.undo();
    }
}
