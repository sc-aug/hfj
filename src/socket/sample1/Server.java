package socket.sample1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private String[] outList = {
            "A reader lives a thousand lives before he dies, said Jojen. The man who never reads lives only one.",
            "We read to know we're not alone.",
            "Never trust anyone who has not brought a book with them.",
            "You can never get a cup of tea large enough or a book long enough to suit me.",
            "If one cannot enjoy reading a book over and over again, there is no use in reading it at all.",
            "The more that you read, the more things you will know. The more that you learn, the more places you'll go."
    };

    private void go() {
        try {
            ServerSocket ss = new ServerSocket(4242);
            Socket cur = ss.accept();
            
            PrintWriter writer = new PrintWriter(cur.getOutputStream());
            
            String o = getOutput();
            writer.println(o);
            writer.close();
            System.out.println(o);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String getOutput() {
        return outList[(int) (Math.random() * outList.length)];
    }
    
    public static void main(String[] args) {
        Server s = new Server();
        s.go();
    }
}
