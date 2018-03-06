package socket.sample3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    
    BufferedReader reader;
    Socket sock;
    
    public ClientHandler(Socket clientSocket) {
        try {
            sock = clientSocket;
            InputStreamReader isr = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(isr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void run() {
        String msg;
        try {
            while ((msg = reader.readLine()) != null) {
                System.out.println("got message from user: " + msg);
                ChatServer.tellEveryone(msg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
