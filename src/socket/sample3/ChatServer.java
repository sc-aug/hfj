package socket.sample3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer {

    // list of instance of PrintWriter
    static ArrayList clientOutputStreams;

    public static void main(String[] args) {
        ChatServer s = new ChatServer();
        s.go();
    }

    private void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket ss = new ServerSocket(4242);
            while (true) {
                Socket curSock = ss.accept();
                PrintWriter writer = new PrintWriter(curSock.getOutputStream());
                clientOutputStreams.add(writer);
                Thread t = new Thread(new ClientHandler(curSock));
                t.start();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void tellEveryone(String msg) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            System.out.println("message send " + msg);
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(msg);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
