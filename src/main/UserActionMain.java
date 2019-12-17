package main;

import cpn.EncodeDecode;
import cpn.JavaCPN;

import java.io.IOException;
import java.util.Scanner;

public class UserActionMain {

    public static void main(String[] args) throws IOException {
        JavaCPN conn = new JavaCPN();
        Scanner scan = new Scanner(System.in);
        String ip = "";
        System.out.println("Type IP to execute an action:");
        ip = scan.nextLine();
        System.out.println("User actions thread start.");
        conn.accept(9002);

        System.out.println("Choose an action:");
        System.out.println("1 - DROP " + ip);
        System.out.println("2 - ACCEPT " + ip);

        int opc = scan.nextInt();


        System.out.println("Sending to CPN Tools the chosen option.");
        switch (opc) {
            case 1:
                conn.send(EncodeDecode.encodeString("DROP " + ip));
                break;
            default:
                conn.send(EncodeDecode.encodeString("ACCEPT " + ip));
                break;
        }

        System.out.println("User actions thread end.");
        conn.disconnect();
    }
}
