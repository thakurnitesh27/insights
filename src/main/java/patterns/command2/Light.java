package patterns.command2;

public class Light implements Appliances {
  private   Glow glow;
    {
         glow=new Glow();
    }
    @Override
    public void setOn() {
       glow.performBulbGlow();
    }

    @Override
    public void setOff() {
glow.dimLightGracefull();
    }


  private class Glow {

      public void performBulbGlow() {
          //do operation.
      }

      public void dimLightGracefull() {
          //do operation
      }


  }
}