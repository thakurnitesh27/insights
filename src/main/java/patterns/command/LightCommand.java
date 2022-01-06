package patterns.command;

public class LightCommand extends Command{

   // Onable onable;

    public LightCommand(Onable onable) {
        super(onable);
       // this.onable = onable;
    }

    @Override
    public void execute(State state) {

        System.out.println("Switching  Light-"+ state.name());
        onable.setState(state);
    }


}
