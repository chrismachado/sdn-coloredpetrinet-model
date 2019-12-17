package main;

import comp.ControlDevice;
import comp.ForwardDevice;
import comp.NetDevice;
import cpn.EncodeDecode;
import cpn.JavaCPN;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class ForwardRunner {

    public static ForwardDevice runRcv(JavaCPN conn) throws SocketException, IOException {
        if (conn == null) return null;
        ByteArrayOutputStream outputStream;

        ForwardDevice fwd = new ForwardDevice(0);
        System.out.println("\tForward runner connection established");

        System.out.println("\tReceiving NetDev...");
        outputStream = conn.receive();
        System.out.println("\tDecoding NetDev from CPN Tools.");
        NetDevice dv1 = EncodeDecode.decodeNetDevice(outputStream);

        System.out.println("\tSetting last flow into Forward Device.");
        fwd.setLastFlow(dv1.toString());
        System.out.println("\tLast flow added " + fwd);
        System.out.println("\tForward runner disconnected");

        return fwd;
    }
    public static void runSnd(JavaCPN conn, ForwardDevice fwd) throws SocketException, IOException {
        if (conn == null) return;
        System.out.println("\tForward sender connection established");
        System.out.println("\tSending forward dev");
        conn.send(EncodeDecode.encodeString(fwd.toString()));
        System.out.println("\tForward sender disconnected");
    }



}
