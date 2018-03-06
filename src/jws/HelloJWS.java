package jws;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HelloJWS {

    public static void main(String[] args) {
        try {
            String fn = System.getProperty("user.dir") + "/hello.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fn, false));
            writer.write("jws sample works!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }
    }

}
