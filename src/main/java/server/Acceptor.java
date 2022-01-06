package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Acceptor implements Runnable {

    private final int port;
    private ServerSocket serverSocket;

    public Acceptor(int port) {
        this.port = port;
        System.out.println("Server listening on port: "+port);
        try {
            serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {

       while (true) {

           Socket socket = serverSocket.accept();
           System.out.println("New client connected...");
           communicateToInitiator(socket);

       }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void communicateToInitiator(Socket socket)
    {


        Thread t1=new Thread(()->{
            try {
                PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                Scanner input=new Scanner(socket.getInputStream());
                System.out.println(" Thread Waiting for data from client");

        String clientId=input.next();
                System.out.println("Server: Message received: "+clientId);
        //input.close();


        writer.write("Client"+ clientId+" is connected successfully at port "+ socket.getPort()+"\n");
        writer.flush();
        input.close();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
        });

        t1.start();
    }
}
