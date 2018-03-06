package socket.sample3;

import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {
    
    private Socket s;
    private BufferedReader reader;
    private PrintWriter writer;
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("please specify your name, as an argument for the program");
            return;
        }
        Client c = new Client();
        c.go(args[0]);
    }
    
    private void go(String name) {
        setupConn(name);
        Thread t = new Thread(new IncomingReader());
        t.start();
    }

    private void setupConn(String name) {
        helpInfo();
        try {
            s = new Socket("127.0.0.1", 4242);
            writer = new PrintWriter(s.getOutputStream());
            Scanner userInput = new Scanner(System.in);
            boolean sign = true;
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (sign) {
                sign = controller(userInput.nextLine(), writer, name);
            }
            System.out.println("exit");
            reader.close();
            writer.close();
            s.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void helpInfo() {
        String text =
                "==============================\n" +
                " Command List\n" +
                " :h              help\n" +
                " :q              exit\n" +
                " :m [message]    send message\n" +
                "==============================";
        System.out.println(text);
    }
    
    private static boolean controller(String input, PrintWriter writer, String name) {
        if (! isValid(input)) {
            helpInfo();
            return true;
        }
        
        String head = input.substring(0, 2);
        
        if (head.equals(":q")) {
            
            return false;
        }
        
        if (head.equals(":h")) {
            helpInfo();
        }
        
        
        if (head.equals(":m")){
            String content = input.substring(2).trim();
            if (content.length() == 0) {
                
            } else {
                sendMessage(content, writer, name);
            }
        }
        
        return true;
    }
    
    private static boolean isValid(String in) {
        if (in == null || in.length() < 2) return false;
        if (in.charAt(0) == ':' 
                && (in.charAt(1) == 'h' || in.charAt(1) == 'm') || in.charAt(1) == 'q') return true;
        return false;
    }
    
    private static void sendMessage(String msg, PrintWriter writer, String name) {
        writer.println(name + ": " + msg);
        writer.flush();
    }
    
    public class IncomingReader implements Runnable {
        public void run() {
            String msg;
            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
