package socket.sample1;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    
    private void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            
            String out = reader.readLine();
            System.out.println(out);
            
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Client c = new Client();
        c.go();
    }
}
