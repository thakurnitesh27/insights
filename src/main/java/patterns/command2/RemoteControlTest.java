package patterns.command2;

public class RemoteControlTest {


    public static void main(String[] args) {
        Light light=new Light();
        Command lightOnCommand=new LightCommand(light);
        Command[] onCommand=new Command[]{lightOnCommand};
        Command[] offCommand=new Command[]{lightOnCommand};
        RemoteControl remoteControl=new RemoteControl(onCommand,offCommand);
    }

}
