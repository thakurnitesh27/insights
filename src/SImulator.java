import client.Initiator;
import server.Acceptor;

import java.io.IOException;

public class SImulator {

    public static void main(String[] args) throws IOException, InterruptedException {
        Acceptor acceptor=new Acceptor(7000);
        Thread acceptorThread=new Thread(acceptor);
        acceptorThread.start();
        acceptorThread.join(500);
        Initiator initiator;
        for(int i=0;i<5;i++) {
      initiator  =new Initiator();
            initiator.connectToAcceptor("localhost", 7000);
        }
    }
}
