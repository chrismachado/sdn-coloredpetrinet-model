package main;

import comp.Action;
import comp.ControlDevice;
import comp.ForwardDevice;
import comp.NetDevice;
import cpn.EncodeDecode;
import cpn.JavaCPN;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class ControlRunner {

    public static ControlDevice runRcv(JavaCPN conn) throws SocketException, IOException {
        if (conn == null) return null;
        ByteArrayOutputStream outputStream;
        ControlDevice ctr = new ControlDevice("c0");
        System.out.println("\tControl runner connection established");
        System.out.println("\tReceiving flow...");
        outputStream = conn.receive();
        ForwardDevice fwd = EncodeDecode.decodeForwardDevice(outputStream);
        ctr.addDevice(fwd);
        System.out.println("\tForward Device added " + fwd);
        return ctr;
    }

    public static void runRcvAct(JavaCPN conn, ControlDevice ctr) throws SocketException, IOException {
        if (conn == null) return;
        ByteArrayOutputStream outputStream;
        System.out.println("\tReceiving action from southbound interface...");
        outputStream = conn.receive();
        String action = EncodeDecode.decodeString(outputStream);
        System.out.println("\tAction added -> " + action);
        ctr.addAction(action);

        System.out.println("\tControl runner disconnected");
    }



    public static void runDecideAction(JavaCPN conn, ControlDevice ctr) throws SocketException, IOException {
        if (conn == null) return;
        Action currAct = ctr.getLastAction();
        ForwardDevice fwdev = ctr.getLastFwd();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String lasfFlow = fwdev.getLastFlow();
        System.out.println("Last flow from fwd " + lasfFlow);
        outputStream.write(lasfFlow.getBytes());
        NetDevice netddst = EncodeDecode.decodeNetDevice(outputStream);

        if (currAct.getType().equals("DROP") &&
                (currAct.getAddress().equals(netddst.getIpsrc()) ||
                        currAct.getAddress().equals(netddst.getIpdst())))
            conn.send(EncodeDecode.encodeString(""));
        else if (currAct.getType().equals("ACCEPT") &&
                (currAct.getAddress().equals(netddst.getIpsrc()) ||
                        currAct.getAddress().equals(netddst.getIpdst())))
            conn.send(EncodeDecode.encodeString(netddst.getPayload()));


    }
}
