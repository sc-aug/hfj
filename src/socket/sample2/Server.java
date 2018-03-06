package socket.sample2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private void go() {
        try {
            ServerSocket ss = new ServerSocket(4242);
            while (true) {
                Socket cur = ss.accept();
                InputStreamReader streamReader = new InputStreamReader(cur.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                System.out.println("Server gets message:" + reader.readLine());
                reader.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Server s = new Server();
        s.go();
    }
}
