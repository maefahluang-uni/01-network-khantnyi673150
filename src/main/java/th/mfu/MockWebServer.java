package th.mfu;

import java.io.*;
import java.net.*;
import java.security.Provider.Service;

public class MockWebServer implements Runnable {

    private int port;
    private ServerSocket serverSocket;

    public MockWebServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try{ 
        // TODO Create a server socket bound to specified port
        serverSocket = new ServerSocket(port);


        System.out.println("Mock Web Server running on port " + port + "...");

        while (true) {
            // TODO Accept incoming client connections
              // TODO: Read the request from the client using BufferedReader

            // TODO: send a response to the client
            try(
                Socket clientSocket = serverSocket.accept();
            

           
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)){
                     String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n"
                    + "<html><body>Hello, Web! on Port " + port + "</body></html>";

                    out.println(response);
                }
              

          
           

            //

        }
    }
      catch(IOException e){
                    e.printStackTrace();
                }

    }

    public static void main(String[] args) {
        Thread server1 = new Thread(new MockWebServer(8080));
        server1.start();

        Thread server2 = new Thread(new MockWebServer(8081));
        server2.start();

        // type any key to stop the server
        // Wait for any key press to stop the mock web server
        
        System.out.println("Press any key to stop the server...");
        try {
            System.in.read();

            // Stop the mock web server
            server1.stop();
            server1.interrupt();
            server2.stop();
            server2.interrupt();
            System.out.println("Mock web server stopped.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
