package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Initiator {

    static int clientID=1;

    public Initiator() {
    }

    public void connectToAcceptor(String hostname, int port) throws IOException, InterruptedException {
        Socket socket=new Socket(hostname,port);

      //  if(socket.isConnected()) {
          //  Thread.sleep(500);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            Scanner input = new Scanner(socket.getInputStream());
            int tmpClient = clientID;
            writer.write(tmpClient + "\n");
            writer.flush();
            // writer.close();
            System.out.println("Client: Message sent: " + tmpClient);
            clientID++;

            //input.close();
            String data = input.nextLine();
             input.close();
             writer.close();
            System.out.println("Client: Message received: " + data);
        }

  //  }
}
