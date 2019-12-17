package main;

import comp.NetDevice;
import cpn.EncodeDecode;
import cpn.JavaCPN;

import java.io.IOException;
import java.net.SocketException;

public class NetRunner {

    public static void runSnd(JavaCPN conn, NetDevice netdev) throws SocketException, IOException {
        if (conn == null) return;
        netdev = NetRunner.randomDevToSent();
        System.out.println("\tNetwork device runner connection established");

        System.out.println("\tSending device info to CPN Tools...");
        conn.send(EncodeDecode.encodeString(netdev.toString()));

        System.out.println("\tNetwork device runner disconnected");
    }


    private static NetDevice randomDevToSent() {
        double rng = Math.random();
        if (rng > 0.5)
            return new NetDevice("dev1", "192.168.0.1", "192.168.0.2", "FromDev1ToDev2Data2");
        else
            return new NetDevice("dev2", "192.168.0.2", "192.168.0.1", "FromDev2ToDev1Data2");
    }
}
