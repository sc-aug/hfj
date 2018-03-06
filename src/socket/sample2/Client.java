package socket.sample2;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

public class Client {
    
    private void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            String str = "Message from client X";
            writer.println(str);
            writer.flush();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Client c = new Client();
        c.go();
    }
    
}
